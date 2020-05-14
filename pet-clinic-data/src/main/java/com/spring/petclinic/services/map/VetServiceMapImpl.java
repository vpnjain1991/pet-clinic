package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
    public Set<Vet> findAll() {
        return super.findAll();
    }

    public Vet findById(Long id) {
        return super.findById(id);
    }

    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    public void delete(Vet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
