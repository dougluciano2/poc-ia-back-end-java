package io.dougluciano.poc.api_notas.API.notas.Fiscais.model;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.base.AbstractEntity;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums.PersonType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_person")
@Getter @Setter @Builder
public class Person extends AbstractEntity {

    @Column(name = "person_name", nullable = false, length = 150)
    private String name;

    @Column(name = "person_document", nullable = false, unique = true, length = 18)
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type", nullable = false)
    private PersonType personType;
}
