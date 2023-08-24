package com.unifacisa.app;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unifacisa.entities.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        /** Serialize */
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPersons());
        System.out.println("Dados do JSON -> " + writer);
        FileWriter fileWriter = new FileWriter("data.json");
        fileWriter.write(String.valueOf(writer));
        fileWriter.close();
        System.out.println("Salvos com sucesso no arquivo data.json");

        /** Deserialize */
        String jsonInput = String.valueOf(writer);
        List<Person> p = mapper.readValue(jsonInput, new TypeReference<List<Person>>() {
        });
        System.out.println("Pessoa: " + p);
    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();

        Person p1 = new Person(1, "Darllinson Azevedo", 19, "M", "123.456.789-10", "darllinson@unifacisa.com");
        Person p2 = new Person(2, "Pedro Pereira", 22, "M", "634.908.983-10", "pedro@unifacisa.com");
        Person p3 = new Person(1, "Rafael Macedo", 21, "M", "098.321.098-10", "macedo@unifacisa.com");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        return persons;
    }
}
