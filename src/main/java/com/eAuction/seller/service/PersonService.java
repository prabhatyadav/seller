package com.eAuction.seller.service;

import com.eAuction.seller.dto.InvalidPersonDetailException;
import com.eAuction.seller.exception.PersonNotFoundException;
import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.repository.PersonRepository;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person findPersonByEmailId(String email) {
        return personRepository.findByEmail(email);
    }

    public Person findPerson(String email, String phoneNumber, PersonTypeEnum personType) throws PersonNotFoundException {
        Optional<Person> foundResultPerson = personRepository.findByEmailAndPhoneAndPersonType(email, phoneNumber, personType);
        if (foundResultPerson.isPresent()) {
            return foundResultPerson.get();
        } else {
            throw new PersonNotFoundException("No Result found");
        }
    }

    public Person findPerson(String email) throws PersonNotFoundException {
        Person foundResultPerson = personRepository.findByEmail(email);
        if (foundResultPerson != null) {
            return foundResultPerson;
        } else {
            throw new PersonNotFoundException("No Result found");
        }
    }

    public Person createNewUser(Person person) throws InvalidPersonDetailException {
        try {
            return personRepository.save(person);
        } catch (Exception exception) {
            throw new InvalidPersonDetailException(exception.getMessage());
        }
    }
}
