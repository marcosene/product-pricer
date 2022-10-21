package com.marcosene.productpricer.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ProductPriceId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    private Integer priceList;

    private Integer productId;
}
