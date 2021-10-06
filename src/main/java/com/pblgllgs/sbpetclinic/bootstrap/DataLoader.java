package com.pblgllgs.sbpetclinic.bootstrap;

import com.pblgllgs.sbpetclinic.model.*;
import com.pblgllgs.sbpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
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
        owner1.setAddress("Veinticuatro de enero 178");
        owner1.setCity("Chillan");
        owner1.setTelephone("321654987");

        Pet michaelPet = new Pet();
        michaelPet.setPetType(savedDogPetType);
        michaelPet.setOwner(owner1);
        michaelPet.setName("rock");
        michaelPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(michaelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirtName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Veinticuatro de enero 181");
        owner2.setCity("Chillan");
        owner2.setTelephone("789456123");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setName("lili");
        fionaPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded Vet Specialities...");

        Vet vet1 = new Vet();
        vet1.setFirtName("Pablo");
        vet1.setLastName("Gallegos");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirtName("Rafael");
        vet2.setLastName("gallegos");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
