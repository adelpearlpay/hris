package com.pearlpay.hris.person.service;

import com.pearlpay.hris.person.dto.*;
import com.pearlpay.hris.person.entity.*;
import com.pearlpay.hris.person.repository.PersonalRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonalServiceImplementation implements PersonalServiceInterface {
    private final PersonalRepo personalRepo;

    public PersonalServiceImplementation(PersonalRepo personalRepo) {
        this.personalRepo = personalRepo;
    }


    //POST Save personal information
    @Override
    public PersonalDTO save(PersonalDTO personalDTO) {

        List<AddressInformation> addressInformations=personalDTO.getAddressDTOList()
                .stream()
                .map(a -> {
                    AddressInformation addressInformationNew=AddressInformation.builder().build();
                    BeanUtils.copyProperties(a, addressInformationNew);
                    return addressInformationNew;
                })
                .collect(Collectors.toList());

        List<ContactInformation> contactInformations=personalDTO.getContactDTOList()
                .stream()
                .map(c -> {
                    ContactInformation contactInformationNew =ContactInformation.builder().build();
                    BeanUtils.copyProperties(c,contactInformationNew);
                    return contactInformationNew;
                })
                .collect(Collectors.toList());

        GuardianInformation guardianInformation = GuardianInformation.builder().build();
        BeanUtils.copyProperties(personalDTO.getGuardianDTO(),guardianInformation);

        ParentsInformation parentsInformation = ParentsInformation.builder().build();
        BeanUtils.copyProperties(personalDTO.getParentsDTO(),guardianInformation);
        
        PersonalInformation personalInformation=PersonalInformation
                .builder()
                .firstName(personalDTO.getFirstName())
                .lastName(personalDTO.getLastName())
                .middleName(personalDTO.getMiddleName())
                .birthDate(personalDTO.getBirthDate())
                .gender(personalDTO.getGender())
                .nationality(personalDTO.getNationality())
                .civilStatus(personalDTO.getCivilStatus())
                .religion(personalDTO.getReligion())
                .remarks(personalDTO.getRemarks())
                .addressInformationList(addressInformations)
                .contactInformationList(contactInformations)
                .guardianInformation(guardianInformation)
                .parentsInformation(parentsInformation)
                .build();

        personalInformation.getAddressInformationList()
                .forEach(a -> a.setPersonalInformation(personalInformation));

        personalInformation.getContactInformationList()
                .forEach(c -> c.setPersonalInformation(personalInformation));

        personalInformation.getGuardianInformation().setPersonalInformation(personalInformation);

        personalInformation.getParentsInformation().setPersonalInformation(personalInformation);

        PersonalDTO personalDTONew = PersonalDTO.builder().build();
        BeanUtils.copyProperties(personalRepo.save(personalInformation),personalDTONew);
        return personalDTONew;
    }

    //list all data
    @Override
    public List<PersonalDTO> findAll() {
        return personalRepo.findAll()
                .stream()
                .map(person -> 
                    {
                        List<AddressDTO>  addressDTOS = person.getAddressInformationList()
                                .stream()
                                .map(address ->{
                                    AddressDTO dto = AddressDTO.builder().build();
                                    BeanUtils.copyProperties(address,dto);
                                    return dto;
                                }).collect(Collectors.toList());
                        
                        List<ContactDTO> contactDTOS = person.getContactInformationList()
                                .stream()
                                .map(contact -> {
                                        ContactDTO dto = ContactDTO.builder().build();
                                        BeanUtils.copyProperties(contact,dto);
                                        return dto;
                                }).collect(Collectors.toList());

                        GuardianDTO guardianDTO = GuardianDTO.builder().build();
                        BeanUtils.copyProperties(person.getGuardianInformation(),guardianDTO);

                        ParentsDTO parentsDTO = ParentsDTO.builder().build();
                        BeanUtils.copyProperties(person.getParentsInformation(), parentsDTO);
                        
                        PersonalDTO personalDTO=PersonalDTO
                                .builder()
                                .firstName(person.getFirstName())
                                .lastName(person.getLastName())
                                .middleName(person.getMiddleName())
                                .birthDate(person.getBirthDate())
                                .gender(person.getGender())
                                .nationality(person.getNationality())
                                .civilStatus(person.getCivilStatus())
                                .religion(person.getReligion())
                                .remarks(person.getRemarks())
                                .addressDTOList(addressDTOS)
                                .contactDTOList(contactDTOS)
                                .guardianDTO(guardianDTO)
                                .parentsDTO(parentsDTO)
                                .build();
                        
                        return personalDTO;
                    }
                ).collect(Collectors.toList());
    }
}
