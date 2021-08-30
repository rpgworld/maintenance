package com.midas.maintenance.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
public class Address {

    private String zonecode;
    private String address;
    private String addressEnglish;
    private String addressType;
    private String addressDetails;

    @Builder
    public Address(String zonecode, String address, String addressEnglish, String addressType, String addressDetails) {
        this.zonecode = zonecode;
        this.address = address;
        this.addressEnglish = addressEnglish;
        this.addressType = addressType;
        this.addressDetails = addressDetails;
    }
}
