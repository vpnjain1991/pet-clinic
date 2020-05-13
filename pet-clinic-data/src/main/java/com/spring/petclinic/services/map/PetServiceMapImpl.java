package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Pet;

import java.util.Set;

public abstract class PetServiceMapImpl extends AbstractMapService<Pet, Long>{
    public Set<Pet> findAll() {
        return super.findAll();
    }

    public Pet findById(Long id) {
        return super.findById(id);
    }

    public Pet save(Long id, Pet object) {
        return super.save(id, object);
    }

    public void delete(Pet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
