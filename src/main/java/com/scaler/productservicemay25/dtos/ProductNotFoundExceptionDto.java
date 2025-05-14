package com.scaler.productservicemay25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ProductNotFoundExceptionDto {
    private Long productId;
    private String message;
    private String resolution;
    
}
