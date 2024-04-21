package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.LocalFeature;
import com.example.comfyrental.Repositories.LocalFeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LocalFeatureServiceImpl implements LocalFeatureService {
    LocalFeatureRepository localFeatureRepository;
    @Override
    public LocalFeature saveLocalFeature(LocalFeature localFeature) {
        return localFeatureRepository.save(localFeature);
    }

    @Override
    public LocalFeature updateLocalFeature(LocalFeature localFeature) {
        return localFeatureRepository.save(localFeature);
    }

    @Override
    public LocalFeature findLocalFeatureById(long id) {
        return localFeatureRepository.findById(id).get();
    }

    @Override
    public List<LocalFeature> findAllLocalFeatures() {
        return localFeatureRepository.findAll();
    }

    @Override
    public void deleteAllLocalFeatures() {
        localFeatureRepository.deleteAll();
    }

    @Override
    public void deleteLocalFeatureById(long id) {
        localFeatureRepository.deleteById(id);
    }


}
