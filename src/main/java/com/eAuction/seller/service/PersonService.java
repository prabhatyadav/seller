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
        return personRepository.findByEmailId(email);
    }
    public Person findPerson(String email, String phoneNumber , PersonTypeEnum personType) {
        return personRepository.findByEmailIdAndPhoneNumberAndPersonType(email,phoneNumber,personType);
    }

    public Person Save(Person person) {
        return personRepository.save(person);
    }
}
