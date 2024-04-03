package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    Image addImage(Image img);
    Image updateImage(Image img);
    Image findImageById(long id);
    List<Image> findAllImages();
    void deleteAllImages();
    void deleteImageById(long id);
}
