package com.scaler.productservicemay25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{
    private String title;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
