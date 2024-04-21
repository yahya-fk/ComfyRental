package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Feature;
import com.example.comfyrental.Repositories.FeatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FeatureServiceImpl implements FeatureService{
    FeatureRepository featureRepository;
    @Override
    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature updateFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature findFeatureById(long id) {
        return featureRepository.findById(id).get();
    }

    @Override
    public List<Feature> findAllFeature() {
        return featureRepository.findAll();
    }

    @Override
    public void deleteAllFeature() {
        featureRepository.deleteAll();
    }

    @Override
    public void deleteFeatureById(long id) {
        featureRepository.deleteById(id);
    }
}
