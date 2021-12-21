package com.banquemisr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDto extends BaseDto {
    private boolean isActive;
}
