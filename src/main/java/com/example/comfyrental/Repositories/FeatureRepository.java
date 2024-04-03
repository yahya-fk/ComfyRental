package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Feature;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature,Long> {
}
