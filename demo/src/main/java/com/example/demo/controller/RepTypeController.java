package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.RepType;
import com.example.demo.repository.RepTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/repType")
public class   RepTypeController{

    @Autowired private RepTypeRepo repTypeRepo;

    @GetMapping("/repTypes")
    public List<RepType> repType() {
        return repTypeRepo.findAll();
    }
}