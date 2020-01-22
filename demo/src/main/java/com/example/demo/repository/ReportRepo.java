package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.entity.Report;

@RepositoryRestResource
public interface ReportRepo extends JpaRepository<Report, Long> {

}