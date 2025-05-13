package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.dtos.FakeStoreProductDto;
import com.scaler.productservicemay25.model.Category;
import com.scaler.productservicemay25.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
     private RestTemplate restTemplate;

     public FakeStoreProductService(RestTemplate restTemplate) {
         this.restTemplate = restTemplate;
     }

    @Override
    public Product getSingleProduct(Long productId) {
         ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
         FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
         //convert dto model
         return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto) {
            Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto1);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }

    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
         if(fakeStoreProductDto==null){
             return null;
         }
         Product product = new Product();
         product.setTitle(fakeStoreProductDto.getTitle());
         product.setId(fakeStoreProductDto.getId());
         product.setPrice(fakeStoreProductDto.getPrice());
         product.setDescription(fakeStoreProductDto.getDescription());
         product.setImage(fakeStoreProductDto.getImage());
         Category category = new Category();
         category.setTitle(fakeStoreProductDto.getCategory());
         product.setCategory(category);
          return product;

    }
}
