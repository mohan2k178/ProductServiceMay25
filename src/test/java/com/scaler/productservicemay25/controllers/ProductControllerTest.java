package com.scaler.productservicemay25.controllers;

import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @MockitoBean
    private ProductService productService;
    @Autowired
    private ProductController productController;

   @Test
   public void testGetSingleProductPositiveCase() throws ProductNotFoundException {
       //Arrange
//        Long productId = 10L;
//        Product expectedProduct = new Product();
//        expectedProduct.setId(productId);
//        expectedProduct.setTitle("Test Product");
//        expectedProduct.setPrice(100.00);
//
//        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);


       //Act
       // Product actualProduct = productController.getSingleProduct(productId);


       //Assert
//        assertEquals(expectedProduct, actualProduct);
//        assertEquals(expectedProduct.getId(), actualProduct.getId());
//        assertEquals(expectedProduct.getTitle(), actualProduct.getTitle());
//        assertEquals(expectedProduct.getPrice(), actualProduct.getPrice());
//        assertEquals("Test Product", actualProduct.getTitle());
//        assertEquals(100.00, actualProduct.getPrice());
   }

    public void testGetSingleProductNegativeCase() {
    }


    @Test
    public void testGetSingleProductThrowsProductNotFoundException() throws ProductNotFoundException {
//       when(productService.getSingleProduct(-1L)).thenThrow(new ProductNotFoundException("Please pass the correct Product id"));
//       Exception exception = assertThrows(ProductNotFoundException.class, () -> productController.getSingleProduct(-1L));
//       assertEquals("Please pass the correct Product id", exception.getMessage());
   }
}