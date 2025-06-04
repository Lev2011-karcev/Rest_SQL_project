package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void addPerson(Person person) {
        repository.save(person);
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Person> getByAge(int age) {
        return repository.findByAge(age);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
