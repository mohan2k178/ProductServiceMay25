package com.scaler.productservicemay25.commons;

import com.scaler.productservicemay25.dtos.UserDto;
import com.scaler.productservicemay25.exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {

    @Autowired
    private RestTemplate restTemplate;


    public UserDto validateToken(String tokenValue) {

            ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/auth/validate/" + tokenValue, UserDto.class);
            return responseEntity.getBody();

    }
}
