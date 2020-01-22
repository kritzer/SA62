package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
  
@Entity  
@Data  
@Getter @Setter
@NoArgsConstructor  
@Table
public class RepType  {  
      
  @Id  
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="REPORTTYPE_SEQ")
  @Column(name="REPTYPE_ID",unique = true)
  private Long id;  
 
  @NonNull
  private String repType;  

}