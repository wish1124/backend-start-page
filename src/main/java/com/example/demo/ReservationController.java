package com.example.demo;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservations")
    public List<Map<String, Object>> getReservations() {
        return reservationRepository.findAllWithDetails().stream()
                .map(r -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", r.getId());
                    map.put("title", r.getTitle());
                    map.put("room", r.getRoom().getName());
                    map.put("location", r.getRoom().getLocation());
                    map.put("host", r.getUser().getName());
                    map.put("department", r.getUser().getDepartment());
                    map.put("startTime", r.getStartTime());
                    map.put("endTime", r.getEndTime());
                    map.put("attendees", r.getAttendees());
                    map.put("status", r.getStatus());
                    return map;
                })
                .toList();
    }
}
