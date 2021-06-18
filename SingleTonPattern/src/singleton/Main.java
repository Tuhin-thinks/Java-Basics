package singleton;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance("db_static");
        System.out.println(database.toString());  // this statement returns the address of the instance
    }
}
