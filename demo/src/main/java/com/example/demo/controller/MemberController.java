package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class  MemberController{

    @Autowired
    private  MemberRepo memberRepository;

    @GetMapping("/member")
    public List<Member> findMemberAll() {
        return memberRepository.findAll();
    }
}