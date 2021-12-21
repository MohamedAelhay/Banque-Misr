package com.banquemisr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto extends BaseDto {

    @NotNull(message = "can not be null or empty.")
    private String name;
}
