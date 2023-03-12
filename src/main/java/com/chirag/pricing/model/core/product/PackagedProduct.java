package com.chirag.pricing.model.core.product;

import com.chirag.pricing.model.auxillary.Packaging;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "packaged_product")
@Table(name = "packaged_product")
public class PackagedProduct extends Product{

    @ManyToOne
    private Packaging packaging;

    @Override
    public ValueWithUnit getRate() {
        // calculate rate including packaging rate
        return ValueWithUnit.add(this.rate, packaging.getRate());
    }
}
