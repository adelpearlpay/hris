package com.pearlpay.hris.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IdGenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private Timestamp dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Timestamp dateUpdated;
}
