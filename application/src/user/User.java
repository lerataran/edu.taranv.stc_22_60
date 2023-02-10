package user;

public class User {
    private static int ID_COUNT = 0;
    private int id;
    private String name;
    private String lastName;
    private int age;
    private boolean employed;

    public User(String name, String lastName, int age, boolean employed) {
        this.id = ID_COUNT;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.employed = employed;

        ID_COUNT++;
    }

    public User(int id, String name, String lastName, int age, boolean employed) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.employed = employed;
    }

    public static int getIdCount() {
        return ID_COUNT;
    }

    public static void setIdCount(int idCount) {
        ID_COUNT = idCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var string = sb.append(id).append("|").append(name).append("|").append(lastName).append("|")
                .append(age).append("|").append(employed).append('\n');
        return String.valueOf(string);
    }
}
