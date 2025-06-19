package com.learning.simplecsvprocessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Lazy
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adresseeId;
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
