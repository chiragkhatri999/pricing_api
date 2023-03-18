package com.chirag.pricing.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Unit {
    KG("KG"),
    PER("PER"),
    GM("GM"),
    HOURLY("HOURLY"),
    DAILY("DAILY"),
    MILLIGRAM("MG");

    private String code;
}
