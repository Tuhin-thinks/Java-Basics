import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner sc = new Scanner(System.in);


    private static void showInitialOptions(){
        System.out.println("Please Select one:" +
                "\n\t1. Message Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        int choice = sc.nextInt();
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

    public static void main(String[] args) {


        contacts = new ArrayList<>();
        System.out.println("Welcome to the dark side!");
        Main.showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please Select one:" +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go Back");

        int choice = sc.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
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
            System.out.println("Please enter all of the informations");
        }
    }
}
