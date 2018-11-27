package com.holos.thrift.service;

import com.holos.thrift.generated.DataException;
import com.holos.thrift.generated.Person;
import com.holos.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface{
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param : "+ username);

        Person person = new Person();
        person.setUsername(username);
        person.setAge(12);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {

        System.out.println("Got Client Param: ");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
