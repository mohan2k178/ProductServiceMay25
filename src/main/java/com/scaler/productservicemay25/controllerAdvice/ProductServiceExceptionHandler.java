package com.scaler.productservicemay25.controllerAdvice;

import com.scaler.productservicemay25.dtos.ExceptionDto;
import com.scaler.productservicemay25.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.exceptions.InvalidTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    private final ProductNotFoundExceptionDto productNotFoundExceptionDto;

    public ProductServiceExceptionHandler(ProductNotFoundExceptionDto productNotFoundExceptionDto) {
        this.productNotFoundExceptionDto = productNotFoundExceptionDto;
    }


    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionDto> handleInvalidToken(InvalidTokenException ex) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());                 // "Invalid token provided"
        dto.setResolutionDetails("Token is missing or invalid");
        return new ResponseEntity<>(dto, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        //exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolutionDetails("hdhdhdhhdhdhdhdhdhdhd");
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setResolution("Please try again with a valid product id");
        exceptionDto.setProductId(e.getProductId());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }


}
