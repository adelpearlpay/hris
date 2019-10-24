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
public class GuardianDTO extends BaseEntityDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private String contactNumber;
}
