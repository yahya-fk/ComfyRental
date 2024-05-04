package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.*;
import com.example.comfyrental.Models.BookingModel;
import com.example.comfyrental.Models.HostingModel;
import com.example.comfyrental.Models.LocalDetailModel;
import com.example.comfyrental.Models.LocalNew;
import com.example.comfyrental.Services.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Hostings")
@CrossOrigin(origins = "*")
public class HostingRestController {
    private final HostingService hostingService;
    UserService userService;
    private final LocalService localService;
    ImageService imageService;
    @GetMapping(value = "/ShowALL/{user_idu}")
    public List<LocalDetailModel> showBooking(@PathVariable String user_idu) {
       return hostingService.getHosetedLocalsByUserIds(user_idu);}
    @PostMapping("/newSave")
    public String save(@RequestBody LocalNew localNew){
       try{
           Local local=new Local(localNew);
           User user=userService.findUserById(localNew.getIdU());
           Hosting hosting = new Hosting(localNew);
           hosting.setUser(user);
           hosting.setLocal(local);
           Local localCreated=localService.saveLocal(local);
           hostingService.saveHosting(hosting);
           long idL=localCreated.getIdL();
           System.out.println(idL);
           return String.valueOf(idL);
       }catch (Exception e){
           System.out.println(e.getMessage());
           return "Error";
       }
    }
    @PostMapping("/image/{id}")
    public String uploadProfileImage(@RequestParam("file") MultipartFile file, @PathVariable String id){
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            Local local=localService.findLocalById(Long.parseLong(id));
            Image image=new Image();
            image.setImg(file.getBytes());
            image.setLocal(local);
            imageService.addImage(image);
            return "Khedam";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file.";
        }
    }

}
