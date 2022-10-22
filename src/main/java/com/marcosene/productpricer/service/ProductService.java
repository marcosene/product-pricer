package com.marcosene.productpricer.service;

import com.marcosene.productpricer.model.ProductPrice;

import java.time.LocalDateTime;

public interface ProductService {

    ProductPrice getProductPrice(LocalDateTime currentTime, Integer productId, Integer brandId);
}
