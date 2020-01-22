package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Rating;
import com.example.demo.entity.RepType;
import com.example.demo.repository.RatingRepo;
import com.example.demo.repository.RepTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RepTypeDataloader implements ApplicationRunner {

    @Autowired
    private RepTypeRepo repTypeRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("ปัญหาเว็บไซต์", "เนื้อหาไม่พึงประสงค์", "อื่นๆ").forEach(rep -> {
            RepType repType = new RepType();
            repType.setRepType(rep);
            repTypeRepo.save(repType);
        });
     //   repTypeRepo.findAll().forEach(System.out::println);
    }


}