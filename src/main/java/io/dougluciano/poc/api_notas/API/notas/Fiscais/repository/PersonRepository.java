package io.dougluciano.poc.api_notas.API.notas.Fiscais.repository;

import io.dougluciano.poc.api_notas.API.notas.Fiscais.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
