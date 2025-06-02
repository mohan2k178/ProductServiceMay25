package com.scaler.productservicemay25.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn
    //@JsonBackReference
   // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Category category;


}
