package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Enums.TypeEnums;
import com.example.comfyrental.Models.CardModel;
import com.example.comfyrental.Services.HostingService;
import com.example.comfyrental.Services.ImageService;
import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<CardModel> showAllLocal() {
        List<Image> imageList = imageService.findAllImages();
        List<CardModel> cardModels = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i += 5) {
            CardModel cardModel = new CardModel();
            List<Image> subList = imageList.subList(i, Math.min(i + 5, imageList.size()));

            String[] imgList = new String[subList.size()];
            for (int j = 0; j < subList.size(); j++) {
                imgList[j] = subList.get(j).getImagePath();
            }
            cardModel.setDateStart(subList.get(0).getLocal().getHostingList().get(0).getDateStart().toString());
            cardModel.setDateEnd(subList.get(0).getLocal().getHostingList().get(0).getDateEnd().toString());
            cardModel.setTitle(subList.get(0).getLocal().getName());
            cardModel.setPrice(subList.get(0).getLocal().getPrice());
            cardModel.setImgList(imgList);
            cardModels.add(cardModel);
        }
        return cardModels;
    }
    @GetMapping(value = "/{id}")
    public List<CardModel> showLocal(@PathVariable String id){
        List<Local> localList =localService.findLocalByType(TypeEnums.valueOf(id));
        List<CardModel> cardModels = new ArrayList<>();
        for (Local local:localList) {
            CardModel cardModel = new CardModel();
            String[] imgList = new String[5];
            int i=0;
            for (Image image:local.getImagesList()) {
                imgList[i] = image.getImagePath();
                i++;
            }
            cardModel.setDateStart(local.getHostingList().get(0).getDateStart().toString());
            cardModel.setDateEnd(local.getHostingList().get(0).getDateEnd().toString());
            cardModel.setTitle(local.getName());
            cardModel.setPrice(local.getPrice());
            cardModel.setImgList(imgList);
            cardModels.add(cardModel);
        }
        return cardModels;
    }

}
