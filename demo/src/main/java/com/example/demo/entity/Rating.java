package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity  
@Data  
@Setter @Getter
@NoArgsConstructor  
@Table
public class Rating {

    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RATING_SEQ")
    @Column(name="RATING_ID",unique = true)
    private Long id;

    @NonNull
    private String name;
	
}