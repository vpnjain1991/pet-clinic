package com.springframework.petclinic.services.springdatajpa;

import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.repositories.PetTypeRepository;
import com.springframework.petclinic.services.PetTypeService;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "springdatajpa")
public class PetTypeServiceJPAImpl implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceJPAImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
