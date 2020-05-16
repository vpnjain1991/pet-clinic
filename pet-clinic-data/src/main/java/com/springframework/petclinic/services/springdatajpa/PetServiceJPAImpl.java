package com.springframework.petclinic.services.springdatajpa;

import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.repositories.PetRepository;
import com.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "springdatajpa")
public class PetServiceJPAImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceJPAImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    
    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}