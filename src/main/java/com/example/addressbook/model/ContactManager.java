package com.example.addressbook.model;

// Add necessary class imports
import java.util.ArrayList;
import java.util.List;

/**
 * This contact manager is used to manage the data associated with a given contact object.
 */
public class ContactManager {
    private IContactDAO contactDAO;

    /**
     * This method is used to instantiate a new ContactManager object.
     * @param contactDAO the contact data access object to be used.
     */
    public ContactManager(IContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    /**
     * This method is used to search of a given contact based on the provided
     * query string.
     * @param query The query string to be used when searching for all the contacts.
     * @return A list of contacts which meet the query parameter in the method.
     */
    public List<Contact> searchContacts(String query){
        return contactDAO.getAllContacts()
                .stream()
                .filter(contact -> isContactMatched(contact, query))
                .toList();
    }

    /**
     * This method is used to determine whether a contact matches the provided query string.
     * @param contact the contact to be matched.
     * @param query the query to be compared against with the contact.
     * @return a boolean denoting whether the contact matched or not.
     */
    private boolean isContactMatched(Contact contact, String query){
        if (query == null || query.isEmpty()) return true;
        query = query.toLowerCase();
        String searchString = contact.getFullName()
                + " " + contact.getEmail()
                + " " + contact.getPhone();
        return searchString.toLowerCase().contains(query);
    }

    /**
     * This method utilises the contact data access object to add a given contact to
     * the database.
     * @param contact the contact to be added to the database.
     */
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    /**
     * This method is used to delete a given contact from the database.
     * @param contact the contact to be added to the database.
     */
    public void deleteContact(Contact contact) {
        contactDAO.deleteContact(contact);
    }

    /**
     * This method is used to update a contact record within the database.
     * @param contact the contact to be updated in the database.
     */
    public void updateContact(Contact contact) {
        contactDAO.updateContact(contact);
    }

    /**
     * This method is used to retrieve all the contacts from the database.
     * @return a list of contact objects which were stored in the database.
     */
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }


}
