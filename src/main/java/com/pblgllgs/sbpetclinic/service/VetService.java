package com.pblgllgs.sbpetclinic.service;

import com.pblgllgs.sbpetclinic.model.Owner;
import com.pblgllgs.sbpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
