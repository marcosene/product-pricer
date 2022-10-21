package com.marcosene.productpricer.data;

import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.model.ProductPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPriceId> {
}
