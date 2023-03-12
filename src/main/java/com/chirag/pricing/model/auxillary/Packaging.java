package com.chirag.pricing.model.auxillary;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "packaging")
public class Packaging implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="rate_value")),
            @AttributeOverride(name="unit",column=@Column(name="rate_unit")),
    })
    private ValueWithUnit rate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="quantity_value")),
            @AttributeOverride(name="unit",column=@Column(name="quantity_unit")),
    })
    private ValueWithUnit quantity;
}
