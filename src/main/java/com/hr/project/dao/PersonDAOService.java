package com.hr.project.dao;

import com.hr.project.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Repository("PersonDAO")
@Transactional
public class PersonDAOService implements PersonDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public Person findByName(String name) {
        return null;
    }

    public void savePerson(Person person) {
        entityManager.persist(person);
        System.out.println("Person saved successfully, Person Details=" + person.getUsername());
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public void deletePersonById(long id) {
        Person person = entityManager.getReference(Person.class, id);
        entityManager.remove(person);
    }

    public List<Person> findAllPersons() {
        Query query = entityManager.createQuery("select t from Person t");
        return query.getResultList();

    }

    public void deleteAllPersons() {

    }

    public boolean isPersonExist(Person person) {
        return false;
    }
}
