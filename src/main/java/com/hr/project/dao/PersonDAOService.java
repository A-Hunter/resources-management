package com.hr.project.dao;

import com.hr.project.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Repository("PersonDAO")
@Transactional
public class PersonDAOService implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Person findById(long id) {
        return null;
    }

    public Person findByName(String name) {
        return null;
    }

    public void savePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        System.out.println("Person saved successfully, Person Details="+person.getUsername());

    }

    public void updatePerson(Person person) {

    }

    public void deletePersonById(long id) {

    }

    public List<Person> findAllPersons() {
        return null;
    }

    public void deleteAllPersons() {

    }

    public boolean isPersonExist(Person person) {
        return false;
    }
}
