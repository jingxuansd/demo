package com.jingxuan.demo;

import com.jingxuan.demo.entity.Address;
import com.jingxuan.demo.entity.Country;
import com.jingxuan.demo.entity.Person;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void whenChainingThenOk(){
        Country newZealand = new Country("NZ");
        Address address = new Address(newZealand);
        Person person = new Person("Ross", "98700987");
        person.setAddress(address);

        String countryCode =  Optional.of(person)
                .flatMap(Person::getAddress)
                .flatMap(Address::getCountry)
                .flatMap(Country::getCountryCode)
                .orElse("UnKnown");

        assertThat(countryCode, is("NZ"));
    }

    @Test
    public void whenChainingThenOk2(){
        Student student = new Student();
        student.setUser(null);

        String name = Optional.ofNullable(student).map(Student::getUser).map(User::getName).orElse("Unknown");

        assertThat(name, is("Unknown"));
    }

    @Data
    class Student {
        private User user;
    }

    @Data
    class User {
        private String name;
        private int age;
    }
}
