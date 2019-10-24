package com.pearlpay.hris.person.repository;

import com.pearlpay.hris.person.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonalRepo extends JpaRepository<PersonalInformation, Long> {
}
