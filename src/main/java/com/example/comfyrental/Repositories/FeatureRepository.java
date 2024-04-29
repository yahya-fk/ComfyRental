package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Feature;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature,Long> {
}
