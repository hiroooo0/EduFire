package com.edufire.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    
    @Column(length = 2000)
    private String content;
    
    private Integer durationMinutes;
    private Integer progressPercentage;
    private Boolean isNew;
    private String iconClass; // CSS class for icon container (e.g. 'materi-icon-apar', 'materi-icon-penyebab', etc.)
    
    @Column(length = 2000)
    private String svgIcon;   // Inline SVG path or icon name
}
