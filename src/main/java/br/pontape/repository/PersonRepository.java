package br.pontape.repository;

import br.pontape.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByFirstName(String firstName);

    @Query("SELECT p FROM Person p WHERE LOWER(p.firstName) = LOWER(:firstName)")
    Optional<Person> xptoByFirstName(String firstName);

}
