package com.pblgllgs.sbpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotBlank
    private String firtName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
