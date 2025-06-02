package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.repositories.CategoryRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

}