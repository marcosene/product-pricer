package com.marcosene.productpricer.api.controller;

import com.marcosene.productpricer.api.mapper.ProductPriceMapper;
import com.marcosene.productpricer.api.request.ProductPriceRequest;
import com.marcosene.productpricer.api.response.ProductPriceResponse;
import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/price")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@RequestBody ProductPriceRequest request) {
        ProductPrice productPrice = productService.getProductPrice(
                request.getCurrentTime(),
                request.getProductId(),
                request.getBrandId());
        ProductPriceResponse productPriceResponse = ProductPriceMapper.INSTANCE.getResponse(productPrice);
        return ResponseEntity.ok(productPriceResponse);
    }
}
