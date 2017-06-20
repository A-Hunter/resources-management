package com.hr.project.service;

import com.hr.project.dao.PersonDAO;
import com.hr.project.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    public Person findById(long id) {
        return personDAO.findById(id);
    }

    public Person findByName(String name) {
        return personDAO.findByName(name);
    }

    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }

    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    public void deletePersonById(long id) {
        personDAO.deletePersonById(id);
    }

    public List<Person> findAllPersons() {
        return personDAO.findAllPersons();
    }

    public boolean isPersonExist(Person person) {
        return personDAO.findByName(person.getUsername()) != null;
    }
}
