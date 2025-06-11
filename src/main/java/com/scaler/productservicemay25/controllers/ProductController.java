package com.scaler.productservicemay25.controllers;


import com.scaler.productservicemay25.commons.AuthCommons;
import com.scaler.productservicemay25.exceptions.InvalidTokenException;
import com.scaler.productservicemay25.dtos.UserDto;
import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping( "/products")
public class ProductController {

    private ProductService productService;
    private final RestTemplate restTemplate;
    private AuthCommons authCommons;

//    public ProductController(@Qualifier("selfProductService") ProductService productService) {
      public ProductController(ProductService productService, RestTemplate restTemplate, AuthCommons authCommons) {
         this.productService = productService;
            this.restTemplate = restTemplate;
        this.authCommons = authCommons;
    }

    @GetMapping( "/{id}/{token}")
    public Product getSingleProduct(@PathVariable("id") Long productId, @PathVariable String token) throws ProductNotFoundException {
        //Throw NewException
        UserDto userDto = authCommons.validateToken(token);
        if (userDto == null) {
            throw new InvalidTokenException("Invalid token provided");
        }

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
