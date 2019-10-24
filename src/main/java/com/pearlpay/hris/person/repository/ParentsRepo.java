package com.pearlpay.hris.person.repository;

import com.pearlpay.hris.person.entity.ParentsInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentsRepo extends JpaRepository<ParentsInformation,Long> {
}
