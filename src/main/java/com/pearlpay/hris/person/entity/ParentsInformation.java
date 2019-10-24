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
@Table(name = "parents_information")
public class ParentsInformation extends BaseEntity {

    @Column(name = "father_first_name")
    private String fatherFirstName;

    @Column(name = "father_last_name")
    private String fatherLastName;

    @Column(name = "father_middle_name")
    private String fatherMiddleName;

    @Column(name = "mother_first_name")
    private String motherFirstName;

    @Column(name = "mother_last_name")
    private String motherLastName;

    @Column(name = "mother_middle_name")
    private String motherMiddleName;

    @OneToOne(optional = false)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;


}
