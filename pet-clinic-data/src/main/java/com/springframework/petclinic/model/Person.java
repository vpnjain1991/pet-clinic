package com.springframework.petclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
    }
}
