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
@Table(name = "guardian_information")
public class GuardianInformation extends IdGenEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToOne(optional = false)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
