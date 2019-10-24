package com.pearlpay.hris.person.entity;

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
@Table(name = "contact_information")
public class ContactInformation extends BaseEntity {

    @Column(name = "landline_number")
    private String landlineNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "personal_email")
    private String personalEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

}
