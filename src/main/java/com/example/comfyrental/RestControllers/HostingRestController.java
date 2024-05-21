package com.example.comfyrental.RestControllers;

import com.example.comfyrental.Entities.Booking;
import com.example.comfyrental.Entities.Hosting;
import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Enums.BookingStatusEnums;
import com.example.comfyrental.Models.BookingModel;
import com.example.comfyrental.Models.HostingModel;
import com.example.comfyrental.Models.LocalDetailModel;
import com.example.comfyrental.Services.BookingService;
import com.example.comfyrental.Services.HostingService;
import com.example.comfyrental.Services.LocalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/Hostings")
@CrossOrigin(origins = "*")
public class HostingRestController {
    private final HostingService hostingService;
    private final LocalService localService;
private final BookingService bookingService;
    @GetMapping(value = "/ShowALL/{user_idu}")
    public List<LocalDetailModel> showBooking(@PathVariable String user_idu) {
        return hostingService.getHosetedLocalsByUserIds(user_idu);
    }

    @GetMapping(value = "/ShowAllRequests/{user_id}")
    public Map<String, String> Requests(@PathVariable String user_id) {
        Map<String, String> RequestsDic = new HashMap<>();
        List<LocalDetailModel> HLBUI = hostingService.getHosetedLocalsByUserIds(user_id);
        for (LocalDetailModel localHostId : HLBUI) {
            Local foundLocalById = localService.findLocalById(localHostId.getIdL());
            for (Booking BPU : foundLocalById.getBookingList()) {
                if(BPU.getBookingStatus() != BookingStatusEnums.active){
                String key = foundLocalById.getName() + " - " + foundLocalById.getIdL();
                String value = BPU.getUser().getFirstName() + " " + BPU.getUser().getLastName() + " (User ID: " + BPU.getUser().getIdU() + ")";
                String localInfo = "Local ID: " + foundLocalById.getIdL() + ", Local Name: " + foundLocalById.getName();
                RequestsDic.put(key + " | " + localInfo, value);
            }}
        }
        System.out.println("hayya donnee: "+RequestsDic);
        System.out.println("hayya donnee: "+RequestsDic);
        System.out.println("hayya donnee: "+RequestsDic);
        System.out.println("hayya donnee: "+RequestsDic);
        System.out.println("hayya donnee: "+RequestsDic);
        return RequestsDic;
    }

    @PutMapping("/AcceptRequest/{localId}")
    public String acceptRequest(@PathVariable Long localId, @RequestParam String guestId) {
        try {
            // Find the local by ID
            Local local = localService.findLocalById(localId);

            if (local != null) {
                for (Booking booking : local.getBookingList()) {
                    if (booking.getUser().getIdU().equals(guestId)) {
                        booking.setBookingStatus(BookingStatusEnums.active);
                        bookingService.saveBooking(booking);
                        System.out.println("Request accepted with local id = "+localId+"and guest id = "+guestId);
                        System.out.println("Request accepted with local id = "+localId+"and guest id = "+guestId);
                        System.out.println("Request accepted with local id = "+localId+"and guest id = "+guestId);

                        return "Request accepted with local id = "+localId+"and guest id = "+guestId;
                    }
                }
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                System.out.println("No booking found for the specified guest"+guestId);
                return "No booking found for the specified guest"+guestId;
            } else {
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                System.out.println("Local not found with the local id = "+localId);
                return "Local not found with the local id = "+localId;
            }
        } catch (Exception e) {
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            System.out.println("Error accepting request");
            return "Error accepting request";
        }
    }


    @DeleteMapping("/RejectRequest/{localId}")
    public String rejectRequest(@PathVariable Long localId, @RequestParam String guestId) {
        try {

            Local local = localService.findLocalById(localId);

            if (local != null) {
                for (Booking booking : local.getBookingList()) {
                    if (booking.getUser().getIdU().equals(guestId)) {
                        bookingService.deleteBookingById(booking.getIdB());
                        return "Request rejected with success";
                    }
                }
                return "No booking found for the specified guest"+guestId;
            } else {
                return "Local not found";
            }
        } catch (Exception e) {
            return "Error rejecting request";
        }
    }
}
