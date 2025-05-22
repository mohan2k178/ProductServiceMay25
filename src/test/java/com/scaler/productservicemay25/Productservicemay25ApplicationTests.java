package com.scaler.productservicemay25;

import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Productservicemay25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

//    public Productservicemay25ApplicationTests(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }

    @Test
    void contextLoads() {
    }

    @Test
    void testQuery(){
        Optional<Product> product = productRepository.findProductWithGivenId(1L);
        System.out.println("DEBUG");
    }

}
