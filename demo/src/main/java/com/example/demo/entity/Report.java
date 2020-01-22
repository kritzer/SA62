package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
  
@Entity  
@Table
@Data  
@NoArgsConstructor  
public class Report {       
  @Id   
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="REPORT_SEQ")
  @Column(name="REPORT_ID",unique = true)
  private Long id;  

  @NonNull
  private String title;
  @NonNull
  private String repDetail;
  @NonNull
  private Date repDate;


  @ManyToOne
  private @NonNull Member member;

  @ManyToOne
  private  @NotNull RepType repType;

  @ManyToOne
  private @NotNull Rating rating;

}