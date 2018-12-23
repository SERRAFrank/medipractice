package org.medipractice.formserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    @OneToMany
    private FormCat formCat;

}
