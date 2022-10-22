package com.marcosene.productpricer.service;

import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceImplTests {

    @Autowired
    ProductService productService;

    @Test
    void testPrice1() {
        ProductPrice productPrice = productService.getProductPrice(
                Utils.parseDateTime("2020-06-14-10.00.00"), 35455, 1);
        assertEquals(productPrice.getPrice(), 35.5);
    }

    @Test
    void testPrice2() {
        ProductPrice productPrice = productService.getProductPrice(
                Utils.parseDateTime("2020-06-14-16.00.00"), 35455, 1);
        assertEquals(productPrice.getPrice(), 25.45);
    }

    @Test
    void testPrice3() {
        ProductPrice productPrice = productService.getProductPrice(
                Utils.parseDateTime("2020-06-14-21.00.00"), 35455, 1);
        assertEquals(productPrice.getPrice(), 35.5);
    }

    @Test
    void testPrice4() {
        ProductPrice productPrice = productService.getProductPrice(
                Utils.parseDateTime("2020-06-15-10.00.00"), 35455, 1);
        assertEquals(productPrice.getPrice(), 30.5);
    }

    @Test
    void testPrice5() {
        ProductPrice productPrice = productService.getProductPrice(
                Utils.parseDateTime("2020-06-16-21.00.00"), 35455, 1);
        assertEquals(productPrice.getPrice(), 38.95);
    }

    @Test
    void testPrice6() {
        assertThrows(NoResultException.class, () -> productService.getProductPrice(
                Utils.parseDateTime("2020-06-16-21.00.00"), 35455, 2));
    }
}
