package org.example.javajuniorgbspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.javajuniorgbspring.model.Person;
import org.example.javajuniorgbspring.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping(value = "/persons")
    public List<Person> checkProduct() {
        return personRepository.findAll();
    }
    @GetMapping(value = "/init")
    public void initOb() {
        ArrayList<Person> entities = new ArrayList<>();
        entities.add(getPerson ("vlad", "10"));
        entities.add(getPerson ("vlad1", "11"));
        entities.add(getPerson ("vlad2", "12"));
        entities.add(getPerson ("vlad3", "13"));
        personRepository.saveAll(entities);
    }

    private static Person getPerson (String name, String age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
