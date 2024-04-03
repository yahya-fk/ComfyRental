package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Bill;
import com.example.comfyrental.Entities.Feature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeatureService {
    Feature saveFeature(Feature feature);
    Feature updateFeature(Feature feature);
    Feature findFeatureById(long id);
    List<Feature> findAllFeature();
    void deleteAllFeature();
    void deleteFeatureById(long id);
}
