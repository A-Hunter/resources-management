package com.hr.project.controller;

import com.hr.project.entity.Person;
import com.hr.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@RestController
public class PersonController {

    @Autowired
    PersonService service;


    //-------------------Retrieve All Persons--------------------------------------------------------

    @RequestMapping(value = "/person/", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> listAllPersons() {
        List<Person> persons = service.findAllPersons();
        if (persons.isEmpty()) {
            return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }


    //-------------------Retrieve Single Person--------------------------------------------------------

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
        System.out.println("Fetching Person with id " + id);
        Person person = service.findById(id);
        if (person == null) {
            System.out.println("Person with id " + id + " not found");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }


    //-------------------Create a Person--------------------------------------------------------

    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Person " + person.getUsername());

        if (service.isPersonExist(person)) {
            System.out.println("A Person with name " + person.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        service.savePerson(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Person --------------------------------------------------------

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        System.out.println("Updating Person " + id);

        Person currentPerson = service.findById(id);

        if (currentPerson == null) {
            System.out.println("Person with id " + id + " not found");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        currentPerson.setUsername(person.getUsername());
        currentPerson.setAddress(person.getAddress());
        currentPerson.setEmail(person.getEmail());

        service.updatePerson(currentPerson);
        return new ResponseEntity<Person>(currentPerson, HttpStatus.OK);
    }


    //------------------- Delete a Person --------------------------------------------------------

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Person with id " + id);

        Person person = service.findById(id);
        if (person == null) {
            System.out.println("Unable to delete. Person with id " + id + " not found");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        service.deletePersonById(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Persons --------------------------------------------------------

    @RequestMapping(value = "/person/", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deleteAllPersons() {
        System.out.println("Deleting All Persons");

        service.deleteAllPersons();
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
}
