package com.gmail.berezin.serg.lessonlistview.models;


import com.gmail.berezin.serg.lessonlistview.R;

import java.io.Serializable;
import java.util.Random;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String phoneNumber2;
    private int contactPhoto;
    Random random = new Random();
    int count = random.nextInt(5) + 1;

    public Contact() {
        this.name = setName();
        this.phoneNumber = setNumber();
        this.contactPhoto = setPhoto();
        this.phoneNumber2 = null;
    }

    private String setName() {
        switch (count) {
            case 1:
                return "John";
            case 2:
                return "Tod";
            case 3:
                return "Jack";
            case 4:
                return "Soul";
            case 5:
                return "Jim";
        }
        return null;
    }

    private String setNumber() {
        switch (count) {
            case 1:
                return "(056) 788-55-40";
            case 2:
                return "(056) 788-55-41";
            case 3:
                return "(056) 789-45-20";
            case 4:
                return "(056) 738-78-09";
            case 5:
                return "(056) 758-23-21";
        }
        return null;
    }

    private int setPhoto() {
        switch (count) {
            case 1:
                return R.drawable.cont_1;
            case 2:
                return R.drawable.cont_2;
            case 3:
                return R.drawable.cont_3;
            case 4:
                return R.drawable.cont_4;
            case 5:
                return R.drawable.cont_5;
            case 6:
                return R.drawable.cont_6;
            case 7:
                return R.drawable.cont_7;
        }
        return -1;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public int getContactPhoto() {
        return contactPhoto;
    }



    @Override
    public String toString() {
        return name + ", " + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactPhoto != contact.contactPhoto) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        return phoneNumber != null ? phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + contactPhoto;
        return result;
    }
}

