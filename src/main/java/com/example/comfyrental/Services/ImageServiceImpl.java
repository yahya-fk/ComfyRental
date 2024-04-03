package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imgrepo;
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
        return null;
    }

    @Override
    public void deleteAllImages() {

    }

    @Override
    public void deleteImageById(long id) {

    }
}
