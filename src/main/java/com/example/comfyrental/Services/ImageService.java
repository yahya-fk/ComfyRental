package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image addImage(Image img);
    Image updateImage(Image img);
    Image findImageById(long id);
    List<Image> findAllImages();
    void deleteAllImages();
    void deleteImageById(long id);
    MultipartFile saveImage(MultipartFile x);
}
