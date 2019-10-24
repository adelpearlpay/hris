package com.pearlpay.hris.person.dto;

import com.pearlpay.hris.base.dto.IdGenEntityDTO;
import com.pearlpay.hris.person.entity.AddressInformation;
import com.pearlpay.hris.person.entity.ContactInformation;
import com.pearlpay.hris.person.entity.GuardianInformation;
import com.pearlpay.hris.person.entity.ParentsInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.List;

//import com.pearlpay.hris.person.entity.AddressInformation;
//import com.pearlpay.hris.person.entity.GuardianInformation;
//import com.pearlpay.hris.person.entity.ParentsInformation;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonalDTO extends IdGenEntityDTO {

    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String gender;
    private String nationality;
    private String civilStatus;
    private String religion;
    private String remarks;
    private List<AddressInformation> addressInformationList;
    private List<ContactInformation> contactInformationList;
    private GuardianInformation guardianInformation;
    private ParentsInformation parentsInformation;
}
