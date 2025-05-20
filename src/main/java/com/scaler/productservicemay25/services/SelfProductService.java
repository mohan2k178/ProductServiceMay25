package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicemay25.exceptions.CategoryNotFoundException;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.model.Category;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.repositories.CategoryRepository;
import com.scaler.productservicemay25.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private final ProductService productService;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }



    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        //return productRepository.findById(productId);
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//        if(optionalProduct.isEmpty()){
//            throw new ProductNotFoundException("Product with id "+productId+" doesn't exist");
//        }
//        return optionalProduct.get();


        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exist."));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {
        Category category = product.getCategory();
        if(category == null){
           throw new CategoryNotFoundException("Invalid Category. Please try agian with Category");
        }

        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if(optionalCategory.isEmpty()){
            category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
