package com.pblgllgs.sbpetclinic.service;

import com.pblgllgs.sbpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

        Owner findByLastName(String lastName);
}
