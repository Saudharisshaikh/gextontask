package com.example.gextontask.MyExternalTest;

public class TestModel {

    String Name;
    String Email;
    String Phone;

    public TestModel() {
    }

    public TestModel(String name, String email, String phone) {
        Name = name;
        Email = email;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
