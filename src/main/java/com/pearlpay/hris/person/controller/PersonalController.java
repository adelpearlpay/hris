package com.pearlpay.hris.person.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearlpay.hris.person.dto.PersonalDTO;
import com.pearlpay.hris.person.entity.AddressInformation;
import com.pearlpay.hris.person.entity.ContactInformation;
import com.pearlpay.hris.person.entity.GuardianInformation;
import com.pearlpay.hris.person.entity.PersonalInformation;
import com.pearlpay.hris.person.service.PersonalServiceImplementation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@RestController
@RequestMapping(path = "api/v1/personal")
public class PersonalController {

    private final String PERSON_FIRST_NAME="firstName";
    private final String PERSON_LAST_NAME="lastName";



    private final PersonalServiceImplementation personalServiceImplementation;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public PersonalController(PersonalServiceImplementation personalServiceImplementation) {
        this.personalServiceImplementation = personalServiceImplementation;
    }

    //POST personal information,
    // list(address information),
    // list(contact information),
    // guardian information,
    // parents information
    @PostMapping
    public ResponseEntity<PersonalDTO> savePersonalInfo(@RequestBody  PersonalDTO personalDTO){
        return new ResponseEntity<>(personalServiceImplementation.save(personalDTO), HttpStatus.OK);
    }

    //GET list(personal information),
    @GetMapping(path = "/all")
    public ResponseEntity<List<PersonalDTO>> getAllPersonalInfo(){
        return ResponseEntity.ok(personalServiceImplementation.findAll());
    }

    //GET by firstName OR/AND lastName
    // personal information,
    // list(address information),
    // list(contact information),
    // guardian information,
    // parents information
    //https://www.baeldung.com/jackson-object-mapper-tutorial
    @GetMapping(path = "/{firstName}")
    public ResponseEntity<List<PersonalDTO>> getOneFullDetails(@RequestBody String input) throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        JsonNode jsonRoot=objectMapper.readTree(input);
        JsonNode jsonFirstName = jsonRoot.get(PERSON_FIRST_NAME);
        JsonNode jsonLastName = jsonRoot.get(PERSON_LAST_NAME);

        String firstName = jsonFirstName.asText();
        String lastName = jsonLastName.asText();

        return ResponseEntity.ok(personalServiceImplementation.findAllByName(firstName, lastName));
    }
}
