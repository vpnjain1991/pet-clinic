package com.springframework.petclinic.services.map;

import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService {
    public Set<Pet> findAll() {
        return super.findAll();
    }

    public Pet findById(Long id) {
        return super.findById(id);
    }

    public Pet save(Pet object) {
        return super.save(object);
    }

    public void delete(Pet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
