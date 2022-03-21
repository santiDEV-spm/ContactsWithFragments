package com.santidev.contactswithfragments;

import java.io.Serializable;

public class Contact implements Serializable {

    private String mName;
    private String mSurname;
    private String mAddress1;
    private String mAddress2;
    private String mZipCode;

    public Contact(String name,
                   String surname,
                   String addres1,
                   String address2,
                   String zipCode){

        this.mName = name;
        this.mSurname = surname;
        this.mAddress1 = addres1;
        this.mAddress2 = address2;
        this.mZipCode = zipCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        this.mSurname = surname;
    }

    public String getAddress1() {
        return mAddress1;
    }

    public void setAddress1(String address1) {
        this.mAddress1 = address1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public void setAddress2(String address2) {
        this.mAddress2 = address2;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        this.mZipCode = zipCode;
    }
}
