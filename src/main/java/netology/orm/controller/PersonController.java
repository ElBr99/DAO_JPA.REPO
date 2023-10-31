package netology.orm.controller;

import lombok.RequiredArgsConstructor;
import netology.orm.dto.IdDto;
import netology.orm.model.Person;
import netology.orm.service.PersonService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping
    public Person updatePerson(IdDto id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @GetMapping("/id")
    public Person getPersonById(IdDto id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @DeleteMapping("/id")
    public void deletePersonById(IdDto id) {
        personService.deletePersonById(id);
    }

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @GetMapping("/age-less-than")
    public List<Person> getPersonByAgeLessThanOrderBy(@RequestParam int age) {
        return personService.getPersonsByAgeLessThanOrderBy(age);
    }

    @GetMapping("/by-name-and-surname")
    public Person getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

}

