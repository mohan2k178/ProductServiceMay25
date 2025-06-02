package com.scaler.productservicemay25.controllers;


import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/products")
public class ProductController {

    private ProductService productService;

//    public ProductController(@Qualifier("selfProductService") ProductService productService) {
      public ProductController(ProductService productService) {
         this.productService = productService;
    }

    @GetMapping( "/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        //Throw NewException

     //   ResponseEntity<Product> responseEntity = new ResponseEntity<>(productService.getSingleProduct(productId), HttpStatus.OK);

          return productService.getSingleProduct(productId);
//        Product product = null;
//        try {
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
        //return responseEntity;
    }

    @GetMapping( "/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {

        return productService.createProduct(product);
    }

    @DeleteMapping( "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){

        productService.deleteProduct(productId);
    }

}
