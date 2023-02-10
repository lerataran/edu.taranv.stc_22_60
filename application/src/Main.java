import user.User;
import user.UsersRepositoryFile;
import user.UsersRepositoryFileImpl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    static String FILE_NAME = "Users.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_NAME);
        UsersRepositoryFile usersRepositoryFile = new UsersRepositoryFileImpl();
        Scanner scanner = new Scanner(System.in);

        if (file.createNewFile()) {
            System.out.println("Файл создан");
        }
        UsersRepositoryFileImpl.intCountId();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите возрат");
        int age = scanner.nextInt();
        System.out.println("Введите работает ли?");
        boolean isJob = scanner.nextBoolean();

        usersRepositoryFile.create(new User(name, lastName, age, isJob));
        usersRepositoryFile.update(new User(5, "Kim", "Kim", 28, true));
        System.out.println(usersRepositoryFile.findById(1));
        usersRepositoryFile.delete(6);

    }


}
