package com.chirag.pricing.model.core.resource;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "resource")
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Embedded
    protected ValueWithUnit rate;
}
