package com.reino.srm.conversor.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {

    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ApiErrorDTO(int status, String message) {
    }
}
