package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MemberDataloader implements ApplicationRunner {

    @Autowired private MemberRepo memberRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("user1", "ไม่ต้องการระบุ").forEach(user -> {
            Member member = new Member();
            member.setUserid(user);
            memberRepo.save(member);
        });
       // memberRepo.findAll().forEach(System.out::println);
    }

    
}