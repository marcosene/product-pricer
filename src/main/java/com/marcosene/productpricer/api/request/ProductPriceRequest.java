package com.marcosene.productpricer.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceRequest {

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime currentTime;

    private Integer productId;

    private Integer brandId;
}
