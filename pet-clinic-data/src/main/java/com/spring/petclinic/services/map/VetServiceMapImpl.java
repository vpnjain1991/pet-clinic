package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Vet;

import java.util.Set;

public abstract class VetServiceMapImpl extends AbstractMapService<Vet, Long>{
    public Set<Vet> findAll() {
        return super.findAll();
    }

    public Vet findById(Long id) {
        return super.findById(id);
    }

    public Vet save(Long id, Vet object) {
        return super.save(id, object);
    }

    public void delete(Vet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
