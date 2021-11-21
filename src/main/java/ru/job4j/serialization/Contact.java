package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "zipCode=" + zipCode
                + ", phone='" + phone + '\'' + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contact contact = new Contact(247001, "+ 375 29 7379376");
        File file = Files.createTempFile(null, null).toFile();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(contact);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Contact rsl = (Contact) in.readObject();
            System.out.println(rsl);
        }
    }
}
