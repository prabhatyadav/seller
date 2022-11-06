package com.eAuction.seller.controller;

import com.eAuction.seller.dto.InvalidPersonDetailException;
import com.eAuction.seller.exception.PersonNotFoundException;
import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class PersonController {

    @Autowired
    public PersonService personService;

    /*Not a requirement*/
    @RequestMapping(method = RequestMethod.GET, value = "/findPerson")
    public Person findPerson(@RequestParam("personType") PersonTypeEnum personTypeEnum,
                             @RequestParam("email") String email,
                             @RequestParam("phoneNumber") String phoneNumber)  {

        Person servicePerson = personService.findPerson(email, phoneNumber, personTypeEnum);
        return servicePerson;
    }

    /*Not a requirement*/
    @RequestMapping(method = RequestMethod.POST, value = "/createNewUser")
    public Person createNewUser(@RequestBody Person person)  {
        return personService.createNewUser(person);
    }


}
