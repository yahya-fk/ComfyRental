package com.example.comfyrental.RestControllers;
import com.example.comfyrental.Models.LocalDetailModel;
import com.example.comfyrental.Models.LocalNew;
import com.example.comfyrental.Services.*;
import com.example.comfyrental.Entities.Local;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Enums.TypeEnums;
import com.example.comfyrental.Models.CardModel;
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
    ImageService imageService;
    private final LocalService localService;

    @GetMapping(value = "/LocalDetails/{id}")
    public LocalDetailModel showLocal(@PathVariable long id) {
        Local local =  localService.findLocalById(id);
        if (local == null){
            return null;
        }
        LocalDetailModel localDetailModel = new LocalDetailModel();
        localDetailModel.setDescLocal(local.getDescLocal());
        localDetailModel.setName(local.getName());
        localDetailModel.setCity(local.getCity());
        localDetailModel.setAddresse(local.getAddresse());
        localDetailModel.setPrice(local.getPrice());
        localDetailModel.setType(local.getType());
        localDetailModel.setHostPic(local.getHostingList().get(0).getUser().getImg());
        localDetailModel.setHostName(local.getHostingList().get(0).getUser().getFirstName()+" "+local.getHostingList().get(0).getUser().getLastName());
        localDetailModel.setDateStart(local.getHostingList().get(0).getDateStart().toString());
        localDetailModel.setDateEnd(local.getHostingList().get(0).getDateEnd().toString());
        localDetailModel.setLocalId(local.getIdL());
        byte[][] imgList = new byte[5][];
        int i=0;
        for (Image image:local.getImagesList()) {
            imgList[i] = image.getImg();
            i++;
        }
        localDetailModel.setImgPathList(imgList);
        return localDetailModel;
    }

    @GetMapping(value = "/showALL")
    public List<CardModel> showAllLocal() {
        List<Image> imageList = imageService.findAllImages();
        List<CardModel> cardModels = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i += 5) {
            CardModel cardModel = new CardModel();
            List<Image> subList = imageList.subList(i, Math.min(i + 5, imageList.size()));

            byte[][] imgList = new byte[subList.size()][];
            for (int j = 0; j < subList.size(); j++) {
                imgList[j] = subList.get(j).getImg();
            }
            cardModel.setDateStart(subList.get(0).getLocal().getHostingList().get(0).getDateStart().toString());
            cardModel.setDateEnd(subList.get(0).getLocal().getHostingList().get(0).getDateEnd().toString());
            cardModel.setTitle(subList.get(0).getLocal().getName());
            cardModel.setPrice(subList.get(0).getLocal().getPrice());
            cardModel.setIdL(subList.get(0).getLocal().getIdL());
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
            byte[][] imgList = new byte[5][];
            int i=0;
            for (Image image:local.getImagesList()) {
                imgList[i] = image.getImg();
                i++;
            }
            cardModel.setDateStart(local.getHostingList().get(0).getDateStart().toString());
            cardModel.setDateEnd(local.getHostingList().get(0).getDateEnd().toString());
            cardModel.setTitle(local.getName());
            cardModel.setPrice(local.getPrice());
            cardModel.setIdL(local.getIdL());
            cardModel.setImgList(imgList);
            cardModels.add(cardModel);
        }
        return cardModels;
    }


}
