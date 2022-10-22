package com.marcosene.productpricer.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceResponse {

    private Integer productId;

    private Integer brandId;

    private Integer priceList;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    private Double price;
}
