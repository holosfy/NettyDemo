package com.holos.thrift.service;

import com.holos.thrift.generated.Person;
import com.holos.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try{

            transport.open();
            Person person = client.getPersonByUsername("zhangsan");
            System.out.println(person);
            System.out.println("-------------");

            Person person2 = new Person();
            person2.setUsername("lisi");
            person2.setAge(13);
            person2.setMarried(true);

            client.savePerson(person2);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            transport.close();
        }
    }
}
