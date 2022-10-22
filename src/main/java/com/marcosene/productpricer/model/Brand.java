package com.marcosene.productpricer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "BRANDS")
public class Brand {

    @Id
    private Integer brandId;

    private String groupName;
}
