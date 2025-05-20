package com.scaler.productservicemay25.model;
import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
