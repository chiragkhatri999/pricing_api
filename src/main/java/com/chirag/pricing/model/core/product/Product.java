package com.chirag.pricing.model.core.product;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.resource.Resource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity which can be sold
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "product")
@Table(name = "product")
public class Product extends Resource {

    public Product(String name, ValueWithUnit rate){
        this.setName(name);
        this.setRate(rate);
    }
}
