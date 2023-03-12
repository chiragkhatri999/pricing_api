package com.chirag.pricing.model.core.resource;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "resource")
@Table(name = "ingredient")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name")
    private String name;

    @Embedded
    protected ValueWithUnit rate;
}
