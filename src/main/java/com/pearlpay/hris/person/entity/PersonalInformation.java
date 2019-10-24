package com.pearlpay.hris.person.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Table(name = "personal_information")
public class PersonalInformation extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "civil_status")
    private String civilStatus;

    @Column(name = "religion")
    private String religion;

    @Column(name = "remarks")
    private String remarks;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AddressInformation> addressInformationList;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ContactInformation> contactInformationList;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private GuardianInformation guardianInformation;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ParentsInformation parentsInformation;
}
