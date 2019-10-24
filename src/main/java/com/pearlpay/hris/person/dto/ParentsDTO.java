package com.pearlpay.hris.person.dto;

import com.pearlpay.hris.base.dto.IdGenEntityDTO;
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
public class ParentsDTO extends IdGenEntityDTO {
    private String fatherFirstName;
    private String fatherLastName;
    private String fatherMiddleName;
    private String motherFirstName;
    private String motherLastName;
    private String motherMiddleName;
    private int numberOfSiblings;
    private List<String> nameOfSiblings = new ArrayList<>();
}
