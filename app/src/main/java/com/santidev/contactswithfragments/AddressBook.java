package com.santidev.contactswithfragments;

import java.util.ArrayList;

public class AddressBook {

    private static AddressBook sharedInstance = new AddressBook();

    private ArrayList<Contact> mContacts;

    //Some hardcode dummy data
    private Contact c1 = new Contact("Bill",
            "Clinton",
            "The White House",
            "Washintog",
            "DC1");

    private Contact c2 = new Contact("John",
            "Snow",
            "El muro",
            "Mas alla de invernalia",
            "Muro001");

    private Contact c3 = new Contact("Christian",
            "Grey",
            "Torre Grey",
            "Seattle",
            "Set69");

    public static AddressBook getInstance(){
        return sharedInstance;
    }

    private AddressBook(){
        this.mContacts = new ArrayList<Contact>();
        this.mContacts.add(this.c1);
        this.mContacts.add(this.c2);
        this.mContacts.add(this.c3);
    }

    public ArrayList<Contact> getContacts(){
        return this.mContacts;
    }

}
