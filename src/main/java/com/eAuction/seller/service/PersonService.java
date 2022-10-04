package com.eAuction.seller.service;

import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person findPersonByEmailId(String email) {
        return personRepository.findByEmail(email);
    }

    public Person findPerson(String email, String phoneNumber, PersonTypeEnum personType) {
        return personRepository.findByEmailAndPhoneAndPersonType(email, phoneNumber, personType);
    }

    public Person createNewUser(Person person) {
        return personRepository.save(person);
    }
}
