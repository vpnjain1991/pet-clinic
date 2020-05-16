package com.springframework.petclinic.repositories;

import com.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Vet, Long> {
}