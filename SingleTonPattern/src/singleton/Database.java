package singleton;

public class Database {
    private String name;

    private static Database instance;

    public static synchronized Database getInstance(String name){  // synchronized method cannot be accessed from multiple threads at a time
        if (null == instance){
            instance = new Database(name);
        }
        return instance;
    }

    private Database(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Database class\nName: " + this.name;
    }
}
