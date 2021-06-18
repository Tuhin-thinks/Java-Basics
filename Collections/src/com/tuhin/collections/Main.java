package com.tuhin.collections;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    void printMap(Map<String, String> names){
        names.forEach((key, value)-> System.out.println(key + " : " + value));
    }

    void print_arrayList(ArrayList<String> arr){
        for (String i : arr){
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        //        String[] names = {"Mahim", "Ram", "Sham", "Jadu", "Ashok"};

        // ways to define ArrayList
        ArrayList<String> names = new ArrayList<>();  // way 1 [size is mutable]
        List<String> students = new ArrayList<>();  // way 2

        names.add("Sarah");
        names.add("Tuhin");
        names.add("Sham");
        names.add("Ram");

        System.out.println("get first element at index 0:" + names.get(0));
        System.out.println("Size of names: " + names.size());

        System.out.println("\"Tuhin\" in names?: " + names.contains("Tuhin"));
        System.out.println("\"Alok\" in names?: " + names.contains("Alok"));

        System.out.println("\nPrint arraylist:");
        obj.print_arrayList(names);

        System.out.println("Index of \"Tuhin\":"+names.indexOf("Tuhin"));

        names.remove(names.get(0));  // remove names first index
        System.out.println("\n___Clearing arraylist___");
        names.clear();  // clear names list

        System.out.println("Is empty? " + names.isEmpty());

        // Map<K, V>
        System.out.println("-----------MAPS----------\n-------------------------");
        Map<String, String> contacts= new HashMap<>();
        contacts.put("Ashok", "askhok@gmail.com");
        contacts.put("Koyel", "k.oyel@gmail.com");
        contacts.put("Rambo", "rambo@gmail.com");
        contacts.put("Jacky", "Jack1234@gmail.com");

        System.out.println("Askhok's email: " + contacts.get("Ashok"));
        System.out.println("Ravi's email: " + contacts.get("Ravi"));

        System.out.println("Size of map: "+ contacts.size());
        System.out.println("[-] removing \"Koyel\" from contacts.");
        contacts.remove("Koyel");

        System.out.println("\nPrint contacts:");
        obj.printMap(contacts);

        System.out.println("""
                -----------ArrayList-------------
                ---------------------------------
                ArrayList supports custom class as List elements""");

        ArrayList<Student> student_list= new ArrayList<>();
        student_list.add(new Student("Alok", "27100118011", "Male", 2018));
        student_list.add(new Student("Ramesh", "27100118012", "Male", 2019));
        student_list.add(new Student("Pratim", "27100118013", "Male", 2020));

        System.out.println("\ngetting each student's details:");
        for (Student s: student_list){
            System.out.println(s.getDetails());
            System.out.println("------------------------------");
        }
    }
}
