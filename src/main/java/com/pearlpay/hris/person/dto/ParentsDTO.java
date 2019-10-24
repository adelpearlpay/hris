package com.pearlpay.hris.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParentsDTO extends BaseEntityDTO {
    private String fatherFirstName;
    private String fatherLastName;
    private String fatherMiddleName;
    private String motherFirstName;
    private String motherLastName;
    private String motherMiddleName;
}
