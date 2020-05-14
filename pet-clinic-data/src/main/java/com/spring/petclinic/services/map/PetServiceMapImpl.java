package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Pet;
import com.spring.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

//@Service
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService {
    public Set<Pet> findAll() {
        return super.findAll();
    }

    public Pet findById(Long id) {
        return super.findById(id);
    }

    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    public void delete(Pet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
