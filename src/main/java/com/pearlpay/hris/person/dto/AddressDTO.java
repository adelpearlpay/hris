package com.pearlpay.hris.person.dto;

import com.pearlpay.hris.person.entity.PersonalInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AddressDTO extends BaseEntityDTO {
    private String type;
    private String unitNumber;
    private String street;
    private String city;
    private String province;
    private String region;
    private String country;
    private long zipCode;
}
