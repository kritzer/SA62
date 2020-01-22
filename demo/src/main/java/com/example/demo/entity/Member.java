package com.example.demo.entity;
import lombok.*;   
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Entity;

@Entity  
@Data  
@Setter @Getter
@NoArgsConstructor  
@Table
public class Member {  
      
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MEMBER_SEQ")  
  private Long id;  

  @NonNull
  private String userid;

}