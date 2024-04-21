package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.LocalFeature;
import com.example.comfyrental.Repositories.LocalFeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalFeatureService {
    LocalFeature saveLocalFeature(LocalFeature localFeature);
    LocalFeature updateLocalFeature(LocalFeature localFeature);
    LocalFeature findLocalFeatureById(long id);
    List<LocalFeature> findAllLocalFeatures();
    void deleteAllLocalFeatures();
    void deleteLocalFeatureById(long id);
}
