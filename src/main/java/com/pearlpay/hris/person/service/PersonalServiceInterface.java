package com.pearlpay.hris.person.service;

import com.pearlpay.hris.person.dto.PersonalDTO;
import com.pearlpay.hris.person.entity.PersonalInformation;

import java.util.List;

public interface PersonalServiceInterface {
    PersonalDTO save(PersonalDTO personalDTO);
    List<PersonalDTO> findAll();
}
