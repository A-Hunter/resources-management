package com.hr.project.dao;

import com.hr.project.entity.Person;

import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
public interface PersonDAO {

    Person findById(long id);

    Person findByName(String name);

    void savePerson(Person person);

    void updatePerson(Person person);

    void deletePersonById(long id);

    List<Person> findAllPersons();

    void deleteAllPersons();

    public boolean isPersonExist(Person person);
}
