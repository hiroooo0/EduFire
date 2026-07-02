package com.edufire.controller;

import com.edufire.model.ActivityLog;
import com.edufire.model.FireHydrant;
import com.edufire.model.Module;
import com.edufire.model.QuizQuestion;
import com.edufire.model.User;
import com.edufire.repository.ActivityLogRepository;
import com.edufire.repository.FireHydrantRepository;
import com.edufire.repository.ModuleRepository;
import com.edufire.repository.QuizQuestionRepository;
import com.edufire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private FireHydrantRepository fireHydrantRepository;

    private User getActiveUser() {
        // Return Budi (first user in DB)
        return userRepository.findAll().stream().findFirst().orElse(null);
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);
        
        // Show first 2 modules for quick study on dashboard
        List<Module> modules = moduleRepository.findAll();
        model.addAttribute("recentModules", modules.subList(0, Math.min(2, modules.size())));
        
        // Load recent activity logs
        if (user != null) {
            List<ActivityLog> logs = activityLogRepository.findByUserIdOrderByIdDesc(user.getId());
            model.addAttribute("activityLogs", logs);
        }
        
        model.addAttribute("currentPage", "dashboard");
        return "dashboard";
    }

    @GetMapping("/materi")
    public String materi(@RequestParam(value = "search", required = false) String search, Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);

        List<Module> modules;
        if (search != null && !search.trim().isEmpty()) {
            modules = moduleRepository.findAll().stream()
                    .filter(m -> m.getTitle().toLowerCase().contains(search.toLowerCase()) 
                            || m.getDescription().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        } else {
            modules = moduleRepository.findAll();
        }

        model.addAttribute("modules", modules);
        model.addAttribute("search", search);
        
        long completedCount = modules.stream().filter(m -> m.getProgressPercentage() != null && m.getProgressPercentage() == 100).count();
        long inProgressCount = modules.stream().filter(m -> m.getProgressPercentage() != null && m.getProgressPercentage() > 0 && m.getProgressPercentage() < 100).count();
        Module continueModule = modules.stream().filter(m -> m.getProgressPercentage() != null && m.getProgressPercentage() > 0 && m.getProgressPercentage() < 100).findFirst().orElse(null);
        
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("inProgressCount", inProgressCount);
        model.addAttribute("continueModule", continueModule);
        
        model.addAttribute("currentPage", "materi");
        return "materi";
    }

    @GetMapping("/materi/{id}")
    public String detailMateri(@PathVariable("id") Long id, Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);

        Optional<Module> moduleOpt = moduleRepository.findById(id);
        if (moduleOpt.isPresent()) {
            Module module = moduleOpt.get();
            model.addAttribute("module", module);
            
            // Mark progress as 100% when read
            if (module.getProgressPercentage() < 100) {
                module.setProgressPercentage(100);
                moduleRepository.save(module);
                
                // Add activity log
                if (user != null) {
                    activityLogRepository.save(new ActivityLog(
                            null, 
                            user.getId(), 
                            "Menyelesaikan Modul: " + module.getTitle(), 
                            "Baru saja", 
                            "+20 Poin"
                    ));
                    // Update user points
                    user.setPoints(user.getPoints() + 20);
                    // Update total progress
                    updateUserOverallProgress(user);
                }
            }
            return "materi-detail";
        }
        return "redirect:/materi";
    }

    private void updateUserOverallProgress(User user) {
        List<Module> all = moduleRepository.findAll();
        if (!all.isEmpty()) {
            double sum = all.stream().mapToInt(Module::getProgressPercentage).sum();
            int avg = (int) Math.round(sum / all.size());
            user.setProgressPercentage(avg);
            
            // Update title and rank based on points
            if (user.getPoints() > 300) {
                user.setLevel(5);
                user.setTitle("Pahlawan Sejati");
                user.setRank("#3");
            } else if (user.getPoints() > 200) {
                user.setLevel(4);
                user.setTitle("Pahlawan Madya");
                user.setRank("#8");
            } else if (user.getPoints() > 150) {
                user.setLevel(3);
                user.setTitle("Pahlawan Pemula");
                user.setRank("#12");
            }
            userRepository.save(user);
        }
    }

    @GetMapping("/kuis")
    public String kuis(Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);
        model.addAttribute("currentPage", "kuis");
        return "kuis";
    }

    @GetMapping("/peta")
    public String peta(Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);
        model.addAttribute("currentPage", "peta");
        return "peta";
    }

    @GetMapping("/profil")
    public String profil(Model model) {
        User user = getActiveUser();
        model.addAttribute("user", user);
        model.addAttribute("currentPage", "profil");
        return "profil";
    }

    @PostMapping("/profil/update")
    public String updateProfil(@ModelAttribute User updatedUser, Model model) {
        User activeUser = getActiveUser();
        if (activeUser != null) {
            activeUser.setName(updatedUser.getName());
            activeUser.setUsername(updatedUser.getUsername());
            activeUser.setBirthDate(updatedUser.getBirthDate());
            activeUser.setEmail(updatedUser.getEmail());
            activeUser.setPhone(updatedUser.getPhone());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().trim().isEmpty()) {
                activeUser.setPassword(updatedUser.getPassword());
            }
            userRepository.save(activeUser);
        }
        return "redirect:/profil?success=true";
    }

    // JSON APIs
    @GetMapping("/api/hydrants")
    @ResponseBody
    public List<FireHydrant> getHydrants() {
        return fireHydrantRepository.findAll();
    }

    @GetMapping("/api/quiz/questions")
    @ResponseBody
    public List<QuizQuestion> getQuizQuestions() {
        return quizQuestionRepository.findAll();
    }

    @PostMapping("/api/quiz/submit-score")
    @ResponseBody
    public ResponseEntity<?> submitQuizScore(@RequestParam("score") Integer score, @RequestParam("pointsEarned") Integer pointsEarned) {
        User user = getActiveUser();
        if (user != null && pointsEarned > 0) {
            user.setPoints(user.getPoints() + pointsEarned);
            updateUserOverallProgress(user);
            
            activityLogRepository.save(new ActivityLog(
                    null, 
                    user.getId(), 
                    "Menyelesaikan Kuis Keselamatan Kebakaran", 
                    "Baru saja", 
                    "+" + pointsEarned + " Poin"
            ));
            return ResponseEntity.ok().body("{\"status\":\"success\", \"newPoints\":" + user.getPoints() + "}");
        }
        return ResponseEntity.ok().body("{\"status\":\"no_update\"}");
    }
}
