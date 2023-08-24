package com.unifacisa.entities;

public class Person {
    private long id;
    private String name;
    private int age;
    private String gender;
    private String cpf;
    private String email;

    public Person() {
    }

    public Person(long id, String name, int age, String gender, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cpf = cpf;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
