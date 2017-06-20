package com.hr.project.service;

import com.hr.project.entity.Person;

import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
public interface PersonService {

    Person findById(long id);

    Person findByName(String name);

    void savePerson(Person person);

    void updatePerson(Person person);

    void deletePersonById(long id);

    List<Person> findAllPersons();

    public boolean isPersonExist(Person person);
}
