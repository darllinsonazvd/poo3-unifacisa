package com.unifacisa.app;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifacisa.entities.Person;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        /** Serialize */
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPersons());
        System.out.println(writer);

        /** Deserialize */
        String jsonInput = "[{\"id\":1,\"name\":\"Lucas\"},{\"id\":2,\"name\":\"Maria\"},{\"id\":3,\"name\":\"Jose\"}]";
        List<Person> p = mapper.readValue(jsonInput, new TypeReference<List<Person>>() {
        });
        System.out.println("Pessoa: " + p);
    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Lucas");

        Person p2 = new Person();
        p2.setId(2);
        p2.setName("Maria");

        Person p3 = new Person();
        p3.setId(3);
        p3.setName("Jose");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        return persons;
    }
}
