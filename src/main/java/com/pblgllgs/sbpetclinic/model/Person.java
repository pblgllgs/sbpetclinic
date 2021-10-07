package com.pblgllgs.sbpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String firtName, String lastName) {
        super(id);
        this.firtName =firtName;
        this.lastName =lastName;
    }

    @Column(name = "first_name")
    @NotBlank
    private String firtName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;


}
