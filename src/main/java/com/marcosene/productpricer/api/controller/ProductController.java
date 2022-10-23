package com.marcosene.productpricer.api.controller;

import com.marcosene.productpricer.api.mapper.ProductPriceMapper;
import com.marcosene.productpricer.api.request.ProductPriceRequest;
import com.marcosene.productpricer.api.response.ProductPriceResponse;
import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@SecurityRequirement(name = "api-scheme")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping(path = "/price")
    public ResponseEntity<ProductPriceResponse> getProductPrice(@RequestBody ProductPriceRequest request) {
        logger.debug("getProductPrice() request=" + request.toString());
        ProductPrice productPrice = productService.getProductPrice(
                request.getCurrentTime(),
                request.getProductId(),
                request.getBrandId());

        ProductPriceResponse response = ProductPriceMapper.INSTANCE.getResponse(productPrice);
        logger.debug("getProductPrice() response=" + response.toString());
        return ResponseEntity.ok(response);
    }
}
