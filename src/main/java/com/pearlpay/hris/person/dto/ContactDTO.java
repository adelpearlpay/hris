package com.pearlpay.hris.person.dto;

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
public class ContactDTO extends BaseEntityDTO {
    private String landlineNumber;
    private String mobileNumber;
    private String personalEmail;
}
