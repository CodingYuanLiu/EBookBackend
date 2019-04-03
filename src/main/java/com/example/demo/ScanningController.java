package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanningController {

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/scanning")
    public String Receiving(@RequestParam(required=false, defaultValue="No params") String book) {
        return book;
    }

}