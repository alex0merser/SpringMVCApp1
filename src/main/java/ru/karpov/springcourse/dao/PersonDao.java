package ru.karpov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.karpov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Bob", 19, "bobbie@internet.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Robert", 15, "robert@gmail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Daniel", 23, "daneiel@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}













