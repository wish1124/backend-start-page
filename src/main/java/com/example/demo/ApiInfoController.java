package com.example.demo;

import com.example.demo.repository.ReservationRepository;
import org.springframework.boot.SpringBootVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ApiInfoController {

    private final ReservationRepository reservationRepository;

    public ApiInfoController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/page")
    public String page(Model model) {
        var reservations = reservationRepository.findAllWithDetails().stream()
                .map(r -> {
                    Map<String, Object> map = new LinkedHashMap<>();
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

        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> apiInfo() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("name", "demo-api");
        info.put("version", "1.0.0");
        info.put("status", "running");
        info.put("timestamp", LocalDateTime.now().toString());
        info.put("framework", "Spring Boot " + SpringBootVersion.getVersion());

        Map<String, String> endpoints = new LinkedHashMap<>();
        endpoints.put("GET /", "API 정보");
        endpoints.put("GET /api/reservations", "회의실 예약 목록 (JSON)");
        endpoints.put("GET /page", "회의실 예약 현황 페이지 (HTML)");
        endpoints.put("GET /actuator/health", "헬스 체크");
        info.put("endpoints", endpoints);

        return ResponseEntity.ok(info);
    }
}
