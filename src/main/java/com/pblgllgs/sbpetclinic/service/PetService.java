package com.pblgllgs.sbpetclinic.service;

import com.pblgllgs.sbpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
