package com.marcosene.productpricer.api.controller;

import com.marcosene.productpricer.api.mapper.ProductPriceMapper;
import com.marcosene.productpricer.api.request.ProductPriceRequest;
import com.marcosene.productpricer.api.response.ProductPriceResponse;
import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@SecurityRequirement(name = "api-scheme")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/price")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@RequestBody ProductPriceRequest request) {
        log.debug("getProductPrice() request=" + request.toString());
        ProductPrice productPrice = productService.getProductPrice(
                request.getCurrentTime(),
                request.getProductId(),
                request.getBrandId());

        ProductPriceResponse response = ProductPriceMapper.INSTANCE.getResponse(productPrice);
        log.debug("getProductPrice() response=" + response.toString());
        return ResponseEntity.ok(response);
    }
}
