package com.gabrielrossilopes.fetcher.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Character {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String status;

    private String species;

    private String gender;
}
