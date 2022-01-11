package com.practice.automationpractice.utils;

import com.github.javafaker.Faker;

import org.joda.time.LocalDateTime;
import org.apache.log4j.Logger;


import java.util.Random;

public class Client {
    private static final Logger log = Logger.getLogger(Client.class);

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirthDays;
    private String dateOfBirthMonth;
    private String dateOfBirthYear;

    private Boolean newsletterConsent;
    private Boolean optinConsent;

    private String company;

    private String address1;
    private String address2;
    private String city;
    private String zipcode;
    private String state;
    private String other;
    private String phone;
    private String mobile;
    private String alias;

    public Client() {
        Faker faker = new Faker();
        title = "Mr" + ((new Random().nextInt() % 2 == 0) ? "s" : "") + ".";
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        LocalDateTime dateOfBirth = new LocalDateTime(faker.date().birthday(18, 60));
        dateOfBirthDays = Integer.toString(dateOfBirth.getDayOfMonth());
        dateOfBirthMonth = Integer.toString(dateOfBirth.getMonthOfYear());
        dateOfBirthYear = Integer.toString(dateOfBirth.getYear());

        newsletterConsent = faker.bool().bool();
        optinConsent = faker.bool().bool();

        company = faker.company().name();

        address1 = faker.address().streetName();
        address2 = faker.address().secondaryAddress();
        city = faker.address().country();
        zipcode = faker.number().digits(5);
        state = faker.address().state();
        other = faker.lorem().sentence(5);
        phone = faker.number().digits(9);
        mobile = faker.number().digits(9);
        alias = faker.lorem().word();
    }

    public String getAlias() {
        return alias;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirthDays() {
        return dateOfBirthDays;
    }

    public String getDateOfBirthMonth() {
        return dateOfBirthMonth;
    }

    public String getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public Boolean getNewsletterConsent() {
        return newsletterConsent;
    }

    public Boolean getOptinConsent() {
        return optinConsent;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getOther() {
        return other;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }

    public Client setZipcode(String postalCode) {
        this.zipcode = postalCode;
        return this;
    }

    public Client setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Client setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Client setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public Client setCity(String city) {
        this.city = city;
        return this;
    }

}
