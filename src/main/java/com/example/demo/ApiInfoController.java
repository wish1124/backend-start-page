package com.example.demo;

import org.springframework.boot.SpringBootVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApiInfoController {

    @GetMapping("/page")
    public String page() {
        return "forward:/page.html";
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
        endpoints.put("GET /page", "도서 대여 신청 페이지");
        endpoints.put("GET /actuator/health", "헬스 체크");
        info.put("endpoints", endpoints);

        return ResponseEntity.ok(info);
    }
}
