package com.bank;


public class Person {
    private String firstname;
    private String lastname;
    private Date date;



    public Person(String firstname, String lastname, Date date) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Date getDate(){
        return this.date;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPerson() {
        return this.firstname + " " + this.lastname + " " + this.date.getDate();
    }
}
