package Homework10.Second;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Contact> contactList;

    public PhoneBook() {
        contactList = new ArrayList<>();
    }

    public void add(String surname, String phoneNumber) {
        contactList.add(new Contact(surname, phoneNumber));
    }

    public void get(String surname) {
        System.out.println("Телефонные номера по запросу '" + surname + "':");
        for (Contact contact : contactList) {
            if (contact.getSurname().equals(surname)) {
                System.out.println(contact.getPhoneNumber());
            }
        }
    }
}
