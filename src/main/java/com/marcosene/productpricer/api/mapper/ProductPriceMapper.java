package com.marcosene.productpricer.api.mapper;

import com.marcosene.productpricer.api.response.ProductPriceResponse;
import com.marcosene.productpricer.model.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPriceMapper {

    ProductPriceMapper INSTANCE = Mappers.getMapper(ProductPriceMapper.class);

    @Mapping(target = "productId", source = "productPriceId.productId")
    @Mapping(target = "brandId", source = "productPriceId.brand.brandId")
    @Mapping(target = "priceList", source = "productPriceId.priceList")
    ProductPriceResponse getResponse(ProductPrice productPrice);
}
