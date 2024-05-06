package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Entities.Image;
import com.example.comfyrental.Entities.User;
import com.example.comfyrental.Models.ImageModel;
import com.example.comfyrental.Models.LocalDetailModel;
import com.example.comfyrental.Repositories.HostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HostingServiceImpl implements HostingService{
    HostingRepository hostingRepository;
    private final UserService userService;
    private final LocalService localService;
    @Override
    public Hosting saveHosting(Hosting hosting) {
        return hostingRepository.save(hosting);
    }

    @Override
    public Hosting updateHosting(Hosting hosting) {
        return hostingRepository.save(hosting);

    }

    @Override
    public Hosting findHostingById(long id) {
        return hostingRepository.findById(id).get();
    }

    @Override
    public List<Hosting> findAllHosting() {
        return hostingRepository.findAll();
    }

    @Override
    public void deleteAllHosting() {
        hostingRepository.deleteAll();
    }

    @Override
    public void deleteHostingById(long id) {
        hostingRepository.deleteById(id);
    }
@Override
    public List<LocalDetailModel> getHosetedLocalsByUserIds(String userId) {
        User user = userService.findUserById(userId);
        List<Hosting> userHostingList = user.getHostingList();

        //hna anjbed les locals li f dik liste userhostinglist
        List<LocalDetailModel> hostedLocals = new ArrayList<>();
        for (Hosting hostedLocal : userHostingList) {
            List<Image> localImages = new ArrayList<>(hostedLocal.getLocal().getImagesList());
            List<ImageModel> imageModels = new ArrayList<>();
            for (Image image : localImages) {
                ImageModel imageModel = new ImageModel();
                imageModel.setImagePath(image.getImg());
                imageModel.setIdI(image.getIdI());
                imageModels.add(imageModel);
            }


            List<byte[]> imagePathList = new ArrayList<>();
            for (ImageModel imageModel : imageModels) {
                imagePathList.add(imageModel.getImagePath());
            }
            byte[][] imgPathArray = imagePathList.toArray(new byte[0][]);

            LocalDetailModel localDetail = new LocalDetailModel(
                    imgPathArray,
                    hostedLocal.getLocal().getAddresse(),
                    hostedLocal.getLocal().getCity(),
                    hostedLocal.getLocal().getType(),
                    hostedLocal.getLocal().getDescLocal(),
                    hostedLocal.getLocal().getName(),
                    hostedLocal.getLocal().getPrice()
            );
localDetail.setIdL(hostedLocal.getLocal().getIdL());
            hostedLocals.add(localDetail);
        }
        return hostedLocals;
    }

}
