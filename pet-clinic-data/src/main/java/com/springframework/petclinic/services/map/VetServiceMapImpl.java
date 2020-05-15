package com.springframework.petclinic.services.map;

import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.Speciality;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.SpecialityService;
import com.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMapImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    public Set<Vet> findAll() {
        return super.findAll();
    }

    public Vet findById(Long id) {
        return super.findById(id);
    }

    public Vet save(Vet object) {
        if (object == null){
            return null;
        }
        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() != null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    public void delete(Vet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
