package com.marcosene.productpricer.api.controller;

import com.marcosene.productpricer.api.exceptions.CustomErrorResponse;
import com.marcosene.productpricer.api.request.ProductPriceRequest;
import com.marcosene.productpricer.api.response.ProductPriceResponse;
import com.marcosene.productpricer.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTests extends AbstractControllerTests {

    private final static String PRODUCT_PRICE_URI = "/product/price";

    private void assertResponse(MockHttpServletResponse response, Double price) throws Exception {
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());

        ProductPriceResponse productPriceResponse = Utils.mapFromJson(
                response.getContentAsString(), ProductPriceResponse.class);
        assertEquals(productPriceResponse.getPrice(), price);
    }

    @Test
    void testPrice1() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-14-10.00.00"));
        request.setProductId(35455);
        request.setBrandId(1);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertResponse(response, 35.5);
    }

    @Test
    void testPrice2() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-14-16.00.00"));
        request.setProductId(35455);
        request.setBrandId(1);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertResponse(response, 25.45);
    }

    @Test
    void testPrice3() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-14-21.00.00"));
        request.setProductId(35455);
        request.setBrandId(1);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertResponse(response, 35.5);
    }

    @Test
    void testPrice4() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-15-10.00.00"));
        request.setProductId(35455);
        request.setBrandId(1);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertResponse(response, 30.5);
    }

    @Test
    void testPrice5() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-16-21.00.00"));
        request.setProductId(35455);
        request.setBrandId(1);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertResponse(response, 38.95);
    }

    @Test
    void testPrice6() throws Exception {
        ProductPriceRequest request = new ProductPriceRequest();
        request.setCurrentTime(Utils.parseDateTime("2020-06-16-21.00.00"));
        request.setProductId(35455);
        request.setBrandId(2);

        MockHttpServletResponse response = postJson(PRODUCT_PRICE_URI, request);
        assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());

        CustomErrorResponse errorResponse = Utils.mapFromJson(response.getContentAsString(), CustomErrorResponse.class);
        assertEquals(errorResponse.getCode(), -1);
        assertEquals(errorResponse.getError(), "No entity found for query");
    }
}
