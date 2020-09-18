package br.pontape.controller;

import br.pontape.entity.Person;
import br.pontape.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons")
    public Iterable<Person> gets() {
        return repository.findAll();
    }

    @GetMapping(path = "/persons/1/{firstName}")
    public Optional<Person> get1(@PathVariable String firstName) {
        return repository.findByFirstName(firstName);
    }

    @GetMapping(path = "/persons/2/{firstName}")
    public Optional<Person> get2(@PathVariable String firstName) {
        return repository.xptoByFirstName(firstName);
    }

    @PostMapping(path = "/person")
    public void post(@RequestBody Person person) {
        repository.save(person);
    }

}
