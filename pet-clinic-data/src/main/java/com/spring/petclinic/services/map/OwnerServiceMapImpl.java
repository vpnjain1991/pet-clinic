package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Owner;

import java.util.Set;

public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long>  {
    public Set<Owner> findAll() {
        return super.findAll();
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Long id, Owner object) {
        return super.save(id, object);
    }

    public void delete(Owner object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
