package com.arjuncodes.studentsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;  // Changed from Name to firstName
    private String lastName;   // Added lastName
    private String address;
    private String phone;      // Added phone
    private String email;      // Added email
    private String cin;        // Added CIN
    private String classe;     // Added classe

    // Default constructor
    public Student() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {  // Changed from Name to firstName
        return firstName;
    }

    public void setFirstName(String firstName) {  // Changed from Name to firstName
        this.firstName = firstName;
    }

    public String getLastName() {  // Added lastName
        return lastName;
    }

    public void setLastName(String lastName) {  // Added lastName
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {  // Added phone
        return phone;
    }

    public void setPhone(String phone) {  // Added phone
        this.phone = phone;
    }

    public String getEmail() {  // Added email
        return email;
    }

    public void setEmail(String email) {  // Added email
        this.email = email;
    }

    public String getCin() {  // Added CIN
        return cin;
    }

    public void setCin(String cin) {  // Added CIN
        this.cin = cin;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
