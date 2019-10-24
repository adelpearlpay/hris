package com.pearlpay.hris.person.repository;

import com.pearlpay.hris.person.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepo extends JpaRepository<ContactInformation, Long> {
}
