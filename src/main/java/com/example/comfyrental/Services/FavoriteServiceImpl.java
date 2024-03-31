package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Favorite;
import com.example.comfyrental.Repositories.FavoriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService{
    FavoriteRepository favoriteRepository;
    @Override
    public Favorite saveFavorite(Favorite favorite) {
        return null;
    }

    @Override
    public Favorite updateFavorite(Favorite favorite) {
        return null;
    }

    @Override
    public Favorite findFavoriteById(long id) {
        return null;
    }

    @Override
    public List<Favorite> findAllFavorites() {
        return null;
    }

    @Override
    public void deleteAllFavorites() {

    }

    @Override
    public void deleteFavoriteById(long id) {

    }
}
