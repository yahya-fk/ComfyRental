package com.example.comfyrental.Controllers;

import com.example.comfyrental.Services.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class FavoriteController {
    private FavoriteService favoriteService;
    @RequestMapping("/createFavorite")
    public String createFavorite(){
        return "Favorite/createFavorite";
    }
}
