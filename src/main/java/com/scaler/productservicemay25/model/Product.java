package com.scaler.productservicemay25.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;


}
