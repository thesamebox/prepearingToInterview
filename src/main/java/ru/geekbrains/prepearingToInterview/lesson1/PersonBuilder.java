package ru.geekbrains.prepearingToInterview.lesson1;

public class PersonBuilder {
    public static void main(String[] args) {
        Person p = new Person.Builder()
                .addFirstName("Peter")
                .addMiddleName("Junior")
                .addLastName("TheBuilder")
                .addGender("boy")
                .addAddress("the nowhere ")
                .addCountry("middle of")
                .addAge(12)
                .addPhone("HeavyPhone")
                .build();

        p.print();

    }
}
