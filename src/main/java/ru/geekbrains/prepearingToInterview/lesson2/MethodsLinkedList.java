package ru.geekbrains.prepearingToInterview.lesson2;

import java.util.ArrayList;

//Visual Paradigm
//Community Edition
//PlantUML
public class MethodsLinkedList {


    public static void main(String[] args) {
//        OwnLinkedList<String> ll = new OwnLinkedList<>();
//        ll.add("каждый");
//        ll.add("охотник");
//        ll.add("желает");
//        ll.add("знать");
//        ll.add("сам");
//        ll.add("где");
//        ll.add("сидит");
//        ll.add("фазан");
//        ll.printList();
//
//        System.out.println("\n   remove охотник");
//        ll.remove("охотник");
//        ll.printList();
//
//        System.out.println("\n   index знать");
//        System.out.println(ll.indexOf("знать"));
//
//        System.out.println("   size");
//        System.out.println(ll.size());
//
//        System.out.println("   contain");
//        System.out.println(ll.contains("фазан"));
//        System.out.println(ll.contains("afpfy"));
//
//        System.out.println("   remove 1");
//        ll.remove(1);
//        ll.printList();
//
//        System.out.println("\n   set 3");
//        ll.set(3, "лопата");
//        ll.printList();
//
//        System.out.println("\n   clear");
//        ll.clear();
//        ll.printList();
        OwnArrayList<String> al = new OwnArrayList<>();
        al.add("Каждый");
        al.add("охотник");
        al.add("Желает");
        al.add("знать");
        al.add("сам");
        al.add("где");
        al.add("сидит");
        al.add("фазан");

        al.printList();

        al.remove(2);
        al.printList();

        al.remove("фазан");
        al.printList();

    }
}





