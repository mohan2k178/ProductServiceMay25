package com.scaler.productservicemay25.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
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
    @JsonIgnore
   // @JsonManagedReference
  //  @OneToMany(fetch = jakarta.persistence.FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
