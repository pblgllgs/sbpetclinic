package com.pblgllgs.sbpetclinic.service;

import java.util.Set;

public interface CrudService<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T objecct);

    void delete(T object);

    void deleteById(ID id);
}
