package com.eAuction.seller.controller;

import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import com.eAuction.seller.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @RequestMapping(method = RequestMethod.GET, value = "/findPerson")
    public Person findPerson(@RequestParam("personType") PersonTypeEnum personTypeEnum,
                             @RequestParam("email") String email,
                             @RequestParam("phoneNumber") String phoneNumber) {

          Person servicePerson =  personService.findPerson(email,phoneNumber,personTypeEnum);
          return servicePerson;
        }



    @RequestMapping(method = RequestMethod.POST, value = "/seller")
    public Person createSeller(@RequestBody Person person) {
        return personService.Save(person);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/buyer")
    public Person createBuyer(@RequestBody Person person) {
        return personService.Save(person);
    }
}
