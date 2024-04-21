package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Repositories.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imgrepo;
    @Override
    public Image addImage(Image img) {
        return imgrepo.save(img);
    }

    @Override
    public Image updateImage(Image img) {
        return imgrepo.save(img);
    }

    @Override
    public Image findImageById(long id) {
        return imgrepo.findById(id).get();
    }

    @Override
    public List<Image> findAllImages() {
        return imgrepo.findAll();
    }

    @Override
    public void deleteAllImages() {
        imgrepo.deleteAll();
    }

    @Override
    public void deleteImageById(long id) {
        imgrepo.deleteById(id);
    }
}
