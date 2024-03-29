package com.banquemisr.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseDto {
    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
