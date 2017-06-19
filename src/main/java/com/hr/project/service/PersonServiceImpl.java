package com.hr.project.service;

import com.hr.project.dao.PersonDAO;
import com.hr.project.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    private static final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonDAO personDAO;

    private static List<Person> persons;

    static {
        persons = personsList();
    }

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findById(long id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getUsername().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        // TODO : IN ORDER TO AVOID "MySQLIntegrityConstraintViolationException: Duplicate entry '1' for key 'PRIMARY",
        // I NEED TO COUNT ALL ITEM IN THE DATABASE AND RETURN THE SUM AND INCREMENT THAT NUMBER AND INJECT IT IN
        // THE NEW PERSON ITEM  --  OR  -- I CAN COUNT THE ITEM EACH TIME I ADD A NEW PERSON OR ITEM
        // IN OTHER TERMS, LIKE THE EXAMPLE OF THE SMPP-PLATFORM == THE NEED OF STORING THE SUM IN THE
        // DATABASE, CONSULT THAT NUMBER EACH TIME I ADD A NEW ITEM AND INCREMENT IT
        // OR
        // A SILLY SOLUTION : DROP THE DATABASE WHEN LAUNCHING THE PROJECT AND CREATE ANOTHER ONE
        person.setId(counter.incrementAndGet());
        persons.add(person);
        //
        personDAO.savePerson(person);
        //
        System.out.println("sht");
    }

    public void updatePerson(Person person) {
//        int index = persons.indexOf(person);
//        persons.set(index, person);
        personDAO.updatePerson(person);
    }

    public void deletePersonById(long id) {

        personDAO.deletePersonById(id);
//        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
//            Person person = iterator.next();
//            if (person.getId() == id) {
//                iterator.remove();
//            }
//        }
    }

    public boolean isPersonExist(Person person) {
        return findByName(person.getUsername()) != null;
    }

    public void deleteAllPersons() {
        persons.clear();
    }

    private static List<Person> personsList() {
        List<Person> persons = new ArrayList<Person>();
//        persons.add(new Person(counter.incrementAndGet(), "Sam", "NY", "sam@abc.com"));
//        persons.add(new Person(counter.incrementAndGet(), "Tomy", "ALBAMA", "tomy@abc.com"));
//        persons.add(new Person(counter.incrementAndGet(), "Kelly", "NEBRASKA", "kelly@abc.com"));
        return persons;
    }

}
