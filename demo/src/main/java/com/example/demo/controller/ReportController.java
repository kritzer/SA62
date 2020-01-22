package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entity.Member;
import com.example.demo.entity.Rating;
import com.example.demo.entity.RepType;
import com.example.demo.entity.Report;
import com.example.demo.repository.MemberRepo;
import com.example.demo.repository.RatingRepo;
import com.example.demo.repository.RepTypeRepo;
import com.example.demo.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportRepo reportRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private RepTypeRepo repTypeRepo;
    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping("/reported")
    public Collection<Report> findReportAll() {
        return reportRepo.findAll();
    }
    
    @PostMapping("/report/add")
    public Report addReport(@RequestBody Map<String, String> body) {
        Report newReport = new Report();
        Rating rating = ratingRepo.findById(Long.valueOf(body.get("rating").toString())).get();
        Member member = memberRepo.findById(Long.valueOf(body.get("member").toString())).get();
        RepType repType = repTypeRepo.findById(Long.valueOf(body.get("repType").toString())).get();

        newReport.setMember(member);
        newReport.setRepType(repType);
        newReport.setRepDate(new Date());
        newReport.setTitle(body.get("title").toString());
        newReport.setRepDetail(body.get("repDetail").toString());
        newReport.setRating(rating);

        return reportRepo.save(newReport);
    }
}

