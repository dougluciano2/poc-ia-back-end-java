package io.dougluciano.poc.api_notas.API.notas.Fiscais.service;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Person;
import io.dougluciano.poc.api_notas.API.notas.Fiscais.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }
}
