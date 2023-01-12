package ru.karpov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.karpov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", "Smith", 17));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "Brown", 18));
        people.add(new Person(++PEOPLE_COUNT, "Samuel", "Taylor", 18));
        people.add(new Person(++PEOPLE_COUNT, "Jack", "Walker", 15));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
