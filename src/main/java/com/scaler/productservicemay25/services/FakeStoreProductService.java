package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.model.Product;

import java.util.List;

public class FakeStoreProductService implements ProductService {


    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
