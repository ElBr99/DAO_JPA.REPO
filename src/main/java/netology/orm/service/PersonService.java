package netology.orm.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import netology.orm.dto.IdDto;
import netology.orm.model.Contact;
import netology.orm.model.Person;
import netology.orm.repo.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(IdDto id) {
        return personRepository.findById(map(id))
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    public Person updatePerson(IdDto id, Person patch) {
        Person person = personRepository.findById(map(id))
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        person.setCityOfLiving(patch.getCityOfLiving());
        person.setPhoneNumber(patch.getPhoneNumber());
        return personRepository.save(person);
    }

    public void deletePersonById(IdDto id) {
        personRepository.deleteById(map(id));
    }

    public List<Person> getPersonByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAgeLessThanOrderBy(int age) {
        return personRepository.findByContactAgeLessThanOrderByContactAge(age);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByContactNameAndContactSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    private Contact map(IdDto idDto) {
        return new Contact(idDto.getName(), idDto.getSurname(), idDto.getAge());
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}