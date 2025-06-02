package com.scaler.productservicemay25;

import com.scaler.productservicemay25.model.Category;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.repositories.CategoryRepository;
import com.scaler.productservicemay25.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Productservicemay25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    public Productservicemay25ApplicationTests(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }

    @Test
    void contextLoads() {
    }
    @Transactional
    @Test
    void testQuery(){
        Optional<Product> product = productRepository.findById(1L);
        System.out.println("DEBUG");

        Optional<Category> category = categoryRepository.findById(1L);
        System.out.println("DEBUG");

        List<Product> products = category.get().getProducts();
        System.out.println(products.get(0).getTitle());
        System.out.println("DEBUG");


    }

}
