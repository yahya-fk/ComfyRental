package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {
    Favorite saveFavorite(Favorite favorite);
    Favorite updateFavorite(Favorite favorite);
    Favorite findFavoriteById(long id);
    List<Favorite> findAllFavorites();
    void deleteAllFavorites();
    void deleteFavoriteById(long id);

}
