package com.springframework.petclinic.bootstrap;

import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Vet;
import com.springframework.petclinic.services.OwnerService;
import com.springframework.petclinic.services.PetTypeService;
import com.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vipin");
        owner1.setLastName("Jain");
        owner1.setAddress("Kondapur, Hyderabad");
        owner1.setCity("Hyderabad");
        owner1.setTelephone("9081726354");

        Pet pet1 = new Pet();
        pet1.setName("Tommy");
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now().minusYears(2));

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Srinu");
        owner2.setLastName("Nampalii");
        owner2.setAddress("Nampalli, Hyderabad");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("1234567890");

        Pet pet2 = new Pet();
        pet2.setName("MegaBite");
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now().minusYears(1));

        owner2.getPets().add(pet2);

        ownerService.save(owner2);



        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ashish");
        vet1.setLastName("Gorai");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Srikant");
        vet2.setLastName("Gajawada");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
