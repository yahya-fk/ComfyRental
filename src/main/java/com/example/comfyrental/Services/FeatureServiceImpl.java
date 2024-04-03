package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Feature;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FeatureServiceImpl implements FeatureService{
    @Override
    public Feature saveFeature(Feature feature) {
        return null;
    }

    @Override
    public Feature updateFeature(Feature feature) {
        return null;
    }

    @Override
    public Feature findFeatureById(long id) {
        return null;
    }

    @Override
    public List<Feature> findAllFeature() {
        return null;
    }

    @Override
    public void deleteAllFeature() {

    }

    @Override
    public void deleteFeatureById(long id) {

    }
}
