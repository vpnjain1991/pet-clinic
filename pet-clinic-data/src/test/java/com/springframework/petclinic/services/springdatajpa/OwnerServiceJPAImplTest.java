package com.springframework.petclinic.services.springdatajpa;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.repositories.OwnerRepository;
import com.springframework.petclinic.repositories.PetRepository;
import com.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPAImplTest {
    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJPAImpl service;

    private final Long OWNER_ID = 1L;
    private String LAST_NAME = "Jain";

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = service.findByLastName(LAST_NAME);
        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(OWNER_ID).build());
        when(ownerRepository.findAll()).thenReturn(returnOwners);
        Set<Owner> result = new HashSet<>();
        service.findAll().forEach(result::add);
        assertEquals(1, result.size());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).build();
        when(ownerRepository.findById(OWNER_ID)).thenReturn(ofNullable(returnOwner));
        Owner result = service.findById(OWNER_ID);
        assertEquals(OWNER_ID, result.getId());
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).build();
        when(ownerRepository.save(returnOwner)).thenReturn(returnOwner);
        Owner result = service.save(returnOwner);
        assertNotNull(result);
        assertEquals(OWNER_ID, returnOwner.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().id(OWNER_ID).build();
        service.delete(owner);
        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteById() {
        Owner owner = Owner.builder().id(OWNER_ID).build();
        service.deleteById(OWNER_ID);
        verify(ownerRepository).deleteById(OWNER_ID);
    }
}