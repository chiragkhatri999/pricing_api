package com.chirag.pricing.model.core.resource;

import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "processed_resource")
@Table(name = "processed_resource")
public class ProcessedResource extends Resource implements Serializable {

    @Nullable
    @ManyToOne
    @JoinColumn(name = "processId", referencedColumnName = "id")
    private Process process;

    @ManyToOne
    @JoinColumn(name = "resourceId", referencedColumnName = "id")
    private Resource derivedFromResource;

    public ProcessedResource(String name, ValueWithUnit rate, Process process, Resource derivedFromResource){
        this.setName(name);
        this.setRate(rate);
        this.setProcess(process);
        this.setDerivedFromResource(derivedFromResource);
    }

}
