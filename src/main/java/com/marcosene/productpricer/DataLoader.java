package com.marcosene.productpricer;

import com.marcosene.productpricer.data.BrandRepository;
import com.marcosene.productpricer.data.ProductPriceRepository;
import com.marcosene.productpricer.model.Brand;
import com.marcosene.productpricer.model.ProductPrice;
import com.marcosene.productpricer.model.ProductPriceId;
import com.marcosene.productpricer.utils.Currency;
import com.marcosene.productpricer.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Brand zaraBrand = new Brand(1, "ZARA");
        brandRepository.save(zaraBrand);

        productPriceRepository.saveAll(List.of(
                new ProductPrice(
                        new ProductPriceId(zaraBrand, 1, 35455),
                        Utils.parseDateTime("2020-06-14-00.00.00"),
                        Utils.parseDateTime("2020-12-31-23.59.59"),
                        0, 35.5, Currency.EUR),
                new ProductPrice(
                        new ProductPriceId(zaraBrand, 2, 35455),
                        Utils.parseDateTime("2020-06-14-15.00.00"),
                        Utils.parseDateTime("2020-06-14-18.30.00"),
                        1, 25.45, Currency.EUR),
                new ProductPrice(
                        new ProductPriceId(zaraBrand, 3, 35455),
                        Utils.parseDateTime("2020-06-15-00.00.00"),
                        Utils.parseDateTime("2020-06-15-11.00.00"),
                        1, 30.5, Currency.EUR),
                new ProductPrice(
                        new ProductPriceId(zaraBrand, 4, 35455),
                        Utils.parseDateTime("2020-06-15-16.00.00"),
                        Utils.parseDateTime("2020-12-31-23.59.59"),
                        1, 38.95, Currency.EUR)

        ));
    }
}
