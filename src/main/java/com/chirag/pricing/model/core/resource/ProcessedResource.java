package com.chirag.pricing.model.core.resource;

import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "processed_product")
@Table(name = "processed_product")
public class ProcessedResource extends Resource {

    @Nullable
    @ManyToOne
    private Process process;

    @ManyToOne
    private Resource derivedFromResource;

    public ProcessedResource(String name, ValueWithUnit rate, Process process, Resource derivedFromResource){
        this.setName(name);
        this.setRate(rate);
        this.setProcess(process);
        this.setDerivedFromResource(derivedFromResource);
    }

}
