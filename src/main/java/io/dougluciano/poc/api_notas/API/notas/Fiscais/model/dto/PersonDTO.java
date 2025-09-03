package io.dougluciano.poc.api_notas.API.notas.Fiscais.model.dto;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Person;

public record PersonDTO (
        Long id,
        String name,
        String document
){

    public static PersonDTO fromEntity(Person person){
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getDocument()
        );
    }
}
