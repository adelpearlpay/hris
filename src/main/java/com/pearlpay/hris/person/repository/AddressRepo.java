package com.pearlpay.hris.person.repository;

import com.pearlpay.hris.person.entity.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressInformation,Long> {
}
