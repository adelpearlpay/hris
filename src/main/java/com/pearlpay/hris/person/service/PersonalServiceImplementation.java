package com.pearlpay.hris.person.service;

import com.pearlpay.hris.person.dto.PersonalDTO;
import com.pearlpay.hris.person.entity.AddressInformation;
import com.pearlpay.hris.person.entity.ContactInformation;
import com.pearlpay.hris.person.entity.PersonalInformation;
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

        List<AddressInformation> addressInformations=personalDTO.getAddressInformationList()
                .stream()
                .map(a -> {
                    AddressInformation addressInformationNew=AddressInformation.builder().build();
                    BeanUtils.copyProperties(a, addressInformationNew);
                    return addressInformationNew;
                })
                .collect(Collectors.toList());

        List<ContactInformation> contactInformations=personalDTO.getContactInformationList()
                .stream()
                .map(c -> {
                    ContactInformation contactInformationNew =ContactInformation.builder().build();
                    BeanUtils.copyProperties(c,contactInformationNew);
                    return contactInformationNew;
                })
                .collect(Collectors.toList());

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
                .guardianInformation(personalDTO.getGuardianInformation())
                .parentsInformation(personalDTO.getParentsInformation())
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
        return null;
    }

    @Override
    public List<PersonalDTO> findAllById(int id) {
        return null;
    }
}
