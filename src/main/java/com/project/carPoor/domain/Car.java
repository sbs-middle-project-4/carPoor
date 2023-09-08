package com.project.carPoor.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
   
    private String name;
   
    private String size;
   
    private String engine;
   
    private Long displacement;

    private String imgUrl;



}
