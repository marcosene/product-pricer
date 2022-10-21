package com.marcosene.productpricer.data;

import com.marcosene.productpricer.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
