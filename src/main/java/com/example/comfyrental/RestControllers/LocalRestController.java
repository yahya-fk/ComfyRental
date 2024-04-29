package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Models.CardModel;
import com.example.comfyrental.Services.ImageService;
import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/local")
@CrossOrigin(origins = "*")
public class LocalRestController {
    LocalService localService;
    ImageService imageService;
    @GetMapping(value = "/showALL")
    public List<CardModel> showAllPerson() {
        List<Image> imageList = imageService.findAllImages();
        List<CardModel> cardModels = new ArrayList<>();

        for (int i = 0; i < imageList.size(); i += 4) {
            CardModel cardModel = new CardModel();
            List<Image> subList = imageList.subList(i, Math.min(i + 4, imageList.size()));

            String[] imgList = new String[subList.size()];
            for (int j = 0; j < subList.size(); j++) {
                imgList[j] = subList.get(j).getImagePath();
            }

            cardModel.setTitle(subList.get(0).getLocal().getName());
            cardModel.setPrice(subList.get(0).getLocal().getPrice());
            cardModel.setImgList(imgList);
            cardModels.add(cardModel);
        }
        return cardModels;
    }

}
