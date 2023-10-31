package netology.orm.repo;

import netology.orm.model.Contact;
import netology.orm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Contact> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByContactAgeLessThanOrderByContactAge(int age);

    Optional<Person> findByContactNameAndContactSurname(String name, String surname);
}
