package com.marcosene.productpricer.service;

import com.marcosene.productpricer.model.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private EntityManager em;

    @Override
    public ProductPrice getProductPrice(LocalDateTime currentTime, Integer productId, Integer brandId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ProductPrice> criteriaQuery = criteriaBuilder.createQuery(ProductPrice.class);
        Root<ProductPrice> productPriceRoot = criteriaQuery.from(ProductPrice.class);

        Predicate predicateBrand
                = criteriaBuilder.equal(productPriceRoot.get("productPriceId").get("brand").get("brandId"), brandId);
        Predicate predicateProduct
                = criteriaBuilder.equal(productPriceRoot.get("productPriceId").get("productId"), productId);
        Predicate predicateStartDate
                = criteriaBuilder.lessThanOrEqualTo(productPriceRoot.get("startDate"), currentTime);
        Predicate predicateEndDate
                = criteriaBuilder.greaterThanOrEqualTo(productPriceRoot.get("endDate"), currentTime);

        Predicate finalPredicate
                = criteriaBuilder.and(predicateBrand, predicateProduct, predicateStartDate, predicateEndDate);

        // Desambiguador de aplicacion de precios
        // Si dos tarifas coinciden en un rago de fechas, se aplica la de mayor prioridad (mayor valor numerico)
        // retornando el primer resultado en un orden descendiente de prioridad
        criteriaQuery.where(finalPredicate).orderBy(criteriaBuilder.desc(productPriceRoot.get("priority")));
        return em.createQuery(criteriaQuery).setFirstResult(0).setMaxResults(1).getSingleResult();
    }
}
