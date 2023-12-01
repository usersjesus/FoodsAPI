package com.FoodsAPI.FoodsAPI.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Nutrients {

    private  @Id
    @GeneratedValue Long id;
    private String name;
    Nutrients () {}

}
