package com.pearlpay.hris.person.entity;

import com.pearlpay.hris.base.entity.IdGenEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "address_information")
public class AddressInformation extends IdGenEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "unit_number")
    private String unitNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private long zipCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
