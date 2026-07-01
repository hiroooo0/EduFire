package com.edufire.repository;

import com.edufire.model.FireHydrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireHydrantRepository extends JpaRepository<FireHydrant, Long> {
}
