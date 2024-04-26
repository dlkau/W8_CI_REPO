package com.example.addressbook.model;

import java.util.regex.Pattern;

/**
 * This contact class is used to store the attributes and method required for a contact within the system.
 */
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     * This constructor is used to instantiate a new Contact object.
     * @param firstname the first name of the contact.
     * @param lastName The last name of the contact.
     * @param email The email of the contact.
     * @param phone The phone number of the contact.
     */
    public Contact(String firstname, String lastName, String email, String phone){
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // Below there are a series of getter and setters for the attributes listed above

    /**
     * Retrieves the id for a given contact.
     * @return the id of the given contact.
     */
    public int getId(){
        return this.id;
    }

    /**
     * This setter is used to set the id for a given contact.
     * @param id the id to be set for the given contact.
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * This getter is used to retrieve the firstname of a given contact.
     * @return th firstname of the contact as a String.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * This setter is used to update the firstname of the contact.
     * @param firstName the firstname the contact needs to be updated with.
     */
    public void setFirstname(String firstName){
        this.firstName = firstName;
    }

    /**
     * This getter is used to retrieve the lastname of a given contact.
     * @return the lastname of the contact as a string.
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * This setter is used to update the lastname of a given contact.
     * @param lastName the lastname the contact's lastname attribute needs to be set to.
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * This method is used to retrieve the email for a given contact.
     * @return the email of the contact as a string.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * This method is used to set the email attribute of a contact with a new value. It also includes validation
     * and will not update the email if it is incorrectly formed.
     * @param email the email the contact object is to be updated with.
     */
    public void setEmail(String email){
        // Check the email address before adding the contact
        String pattern = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        boolean isValidEmail = Pattern.compile(pattern).matcher(email).matches();
        // Return if it is not a valid email
        if(isValidEmail){
            this.email = email;
        }

    }

    /**
     * This getter is used to retrieve the phone number of a given contact.
     * @return a string representing the phoen number of the contact.
     */
    public String getPhone(){
        return this.phone;
    }

    /**
     * This method is used to update the phone number of a given contact.
     * @param phone the phone number the contact's phone number attribute needs to be =
     *              updated with.
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * This method is used to retrieve the firstname, lastname and email of a
     * given contact respectively.
     * @return the firstname, lastname and email of the given contact.
     */
    public String getFullName(){
        return firstName + " " + lastName + "(" + email + ")";
    }
}