package com.marcosene.productpricer.api.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomErrorResponse {

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime timestamp;

    private Integer code;

    private String error;
}
