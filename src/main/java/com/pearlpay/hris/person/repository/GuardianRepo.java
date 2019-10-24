package com.pearlpay.hris.person.repository;

import com.pearlpay.hris.person.entity.GuardianInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepo extends JpaRepository<GuardianInformation,Long> {
}
