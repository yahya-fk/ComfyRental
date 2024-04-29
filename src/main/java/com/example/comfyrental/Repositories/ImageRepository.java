package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findAllByOrderByLocal();
}
