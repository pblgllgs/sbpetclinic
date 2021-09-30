package com.pblgllgs.sbpetclinic.bootstrap;

import com.pblgllgs.sbpetclinic.model.Owner;
import com.pblgllgs.sbpetclinic.model.PetType;
import com.pblgllgs.sbpetclinic.model.Vet;
import com.pblgllgs.sbpetclinic.service.OwnerService;
import com.pblgllgs.sbpetclinic.service.PetTypeService;
import com.pblgllgs.sbpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Owner owner1 = new Owner();
        owner1.setFirtName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirtName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirtName("Pablo");
        vet1.setLastName("Gallegos");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirtName("Rafael");
        vet2.setLastName("gallegos");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
