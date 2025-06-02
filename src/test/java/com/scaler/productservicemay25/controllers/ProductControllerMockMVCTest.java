package com.scaler.productservicemay25.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservicemay25.model.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductService productService;

    @MockitoBean
    private RestTemplate restTemplate;

      @Test
      public void testGetAllProductsAPI() throws Exception {

          Product p1 = new Product();
          p1.setId(1L);
          p1.setTitle("iPhone 6");
          p1.setPrice(100.00);
          p1.setDescription("Phone");

          Product p2 = new Product();
          p2.setId(2L);
          p2.setTitle("iPhone 8");
          p2.setPrice(200.00);
          p2.setDescription("Phone");

          List<Product> products = new ArrayList<>();
          products.add(p1);
          products.add(p2);



          when(productService.getAllProducts()).thenReturn(products);
          String expectedJson = objectMapper.writeValueAsString(products);
         mockMvc.perform(MockMvcRequestBuilders.get("/products/")).andExpect(status().isOk()).andExpect((ResultMatcher) content().json(expectedJson));
      }
}
