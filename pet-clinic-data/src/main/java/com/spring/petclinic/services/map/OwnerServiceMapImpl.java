package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    public void delete(Owner object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
