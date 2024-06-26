package com.example.comfyrental.Services;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Enums.TypeEnums;
import com.example.comfyrental.Repositories.LocalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.List;

@AllArgsConstructor
@Service
public class LocalServiceImpl implements LocalService{
    private LocalRepository localRepository;
    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Local local) {return localRepository.save(local);}
    @Override
    public Local findLocalById(long id) {
        return localRepository.findById(id).get();
    }

    @Override
    public List<Local> findLocalByType(TypeEnums type) {
        return localRepository.findByType(type);
    }

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Page<Local> findAllLocals(int page, int size) {
        return localRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void deleteAllLocals() {
        localRepository.deleteAll();
    }

    @Override
    public void deleteLocalById(long id) {
        localRepository.deleteById(id);
    }
    public Long findBookingIdByUserAndLocalId(long localId, String guestId) {
        Local local = findLocalById(localId);
        if (local != null) {
            List<Booking> bookingList = local.getBookingList();
            for (Booking booking : bookingList) {
                if (guestId.equals(booking.getUser().getIdU())) {
                    return booking.getIdB();
                }
            }
        }
        return null;
    }



}
