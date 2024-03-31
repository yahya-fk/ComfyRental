package com.example.comfyrental.Repositories;

import com.example.comfyrental.Entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
