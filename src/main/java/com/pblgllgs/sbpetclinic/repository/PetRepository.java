package com.pblgllgs.sbpetclinic.repository;

import com.pblgllgs.sbpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository  extends CrudRepository <Pet,Long> {
}
