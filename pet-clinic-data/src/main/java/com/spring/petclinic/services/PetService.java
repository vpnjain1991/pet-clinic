package com.spring.petclinic.services;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
