package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static final Scanner sc = new Scanner(System.in);
    private static int id = 0;

    private static void showInitialOptions(){
        System.out.println("""
                Please Select one:
                \t1. Manage Contacts
                \t2. Messages
                \t3. Quit""");

        int choice = sc.nextInt();
        sc.nextLine();  // consume left over line
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("""
                Please select one:
                \t1. Show all messages
                \t2. Send a new message
                \t3. Go Back""");
        int choice = sc.nextInt();
        sc.nextLine();  // consume left over line
        switch (choice){
            case 1 -> showAllMessages();
            case 2 -> sendNewMessage();
            default -> showInitialOptions();
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send the message? ");
        String name = sc.next();
        if (name.equals("")){
            System.out.println("Please enter the name of the contact");
            sendNewMessage();
        }
        else{
            boolean doesExist=false;
            for (Contact c: contacts){
                if (c.getName().equalsIgnoreCase(name)) {
                    doesExist = true;
                    break;
                }
            }
            if (doesExist){
                System.out.println("Enter Message text: ");
                String text = sc.next();
                if (text.equals("")){
                    System.out.println("Text cannot be empty");
                    sendNewMessage();
                }
                else{
                    id++;  // unique id for every message
                    Message newMessage = new Message(text, name, id);
                    for (Contact c: contacts){
                        if(c.getName().equalsIgnoreCase(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                }
            }
            else
                System.out.println("No contact named " + name + " found.");
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c: contacts){
            allMessages.addAll(c.getMessages());  // add all messages of the contact to the allMessages
        }
        if (allMessages.size() > 0){
            for (Message m: allMessages){
                m.getDetails();
                System.out.println("********************");  // to prettify display of message details
            }
        }
        else
            System.out.println("You don't have any messages.");
        showInitialOptions();
    }

    public static void main(String[] args) {


        contacts = new ArrayList<>();
        System.out.println("Welcome to the dark side!");
        Main.showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("""
                Please Select one:
                \t1. Show all contacts
                \t2. Add a new contact
                \t3. Search for a contact
                \t4. Delete a contact
                \t5. Go Back""");

        int choice = sc.nextInt();
        sc.nextLine();  // consume left over line
        switch (choice) {
            case 1 -> showAllContacts();
            case 2 -> addNewContact();
            case 3 -> searchForContact();
            case 4 -> deleteContact();
            default -> showInitialOptions();
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact name:");
        String name = sc.next();
        if (name.equals("")){
            System.out.println("Please enter the name");
            deleteContact();
        }
        else{
            boolean doesExists=false;
            for (Contact c: contacts){
                if (c.getName().equalsIgnoreCase(name)){
                    System.out.println("Are you sure you want to delete " + c.getName() + " ?");
                    String choice = sc.next();
                    if (choice.equals("yes") || choice.equalsIgnoreCase("y")){
                        contacts.remove(c);
                        break;
                    }
                    else{
                        System.out.println("Deletion of contact aborted.");
                    }
                    doesExists = true;
                }
            }
            if (!doesExists){
                System.out.println("Contact does not exist. Failed to delete contact.");
            }
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name:");
        String name = sc.next();
        if (name.equals("")){
            System.out.println("Please enter the name");
            searchForContact();
        }
        else{
            boolean doesExists=false;
            for (Contact c: contacts){
                if (c.getName().equalsIgnoreCase(name)){
                    c.getDetails();
                    doesExists = true;
                }
            }
            if (!doesExists)
                System.out.println("contact does not exist.");
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        if (contacts.size() > 0) {
            for (Contact c : contacts) {
                c.getDetails();  // prints contact details
                System.out.println("************************");
            }
        } else
            System.out.println("You do not have any saved contacts.");

        showInitialOptions();
    }

    private static void addNewContact(){
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact name:");
        String name = sc.next();
        System.out.println("Please Enter contact's number:");
        String number = sc.next();
        System.out.println("Enter the contact's email:");
        String email = sc.next();

        if (name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContact();
        }
        else{

            boolean doesExist = false;
            for (Contact c: contacts){
                if (c.getName().equalsIgnoreCase(name)){
                    doesExist = true;
                    break;
                }
            }
            if (doesExist){
                System.out.println("You already have a contact saved as:" + name + ". try saving with some other name.");
                addNewContact();
            }
            else{
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println("Name added successfully");
            }
        }
        showInitialOptions();  // show initial options, to simulate a loop (unless user quits)
    }
}
