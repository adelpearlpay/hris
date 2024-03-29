package com.pearlpay.hris.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDTO {
    private Long Id;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
}
