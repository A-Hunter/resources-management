package com.hr.project.service;

import com.hr.project.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Person> persons;

    static{
        persons= personsList();
    }

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findById(long id) {
        for(Person person : persons){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public Person findByName(String name) {
        for(Person person : persons){
            if(person.getUsername().equalsIgnoreCase(name)){
                return person;
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        person.setId(counter.incrementAndGet());
        persons.add(person);
    }

    public void updatePerson(Person person) {
        int index = persons.indexOf(person);
        persons.set(index, person);
    }

    public void deletePersonById(long id) {

        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
            Person person = iterator.next();
            if (person.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isPersonExist(Person person) {
        return findByName(person.getUsername())!=null;
    }

    public void deleteAllPersons(){
        persons.clear();
    }

    private static List<Person> personsList(){
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
        persons.add(new Person(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
        persons.add(new Person(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
        return persons;
    }

}
