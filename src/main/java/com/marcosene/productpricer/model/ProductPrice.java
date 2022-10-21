package com.marcosene.productpricer.model;

import com.marcosene.productpricer.utils.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ProductPrice {

    @EmbeddedId
    private ProductPriceId productPriceId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priority;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Currency curr;
}
