package com.eAuction.seller.repository;

import com.eAuction.seller.model.Person;
import com.eAuction.seller.model.PersonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmailAndPhoneAndPersonType(String emailId, String phoneNumber, PersonTypeEnum personType);

    Person findByEmail(String emailId);
}
