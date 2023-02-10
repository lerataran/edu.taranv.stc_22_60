package user;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsersRepositoryFileImpl implements UsersRepositoryFile {
    String FILE_NAME = "Users.txt";

    public static void intCountId() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Users.txt"))) {
            String line = bufferedReader.readLine();
            String[] arrayUser;
            int count = -1;

            while (line != null) {
                arrayUser = line.split("\\|");
                String str = arrayUser[0];
                count = Integer.parseInt(str);
                line = bufferedReader.readLine();
            }
            if (count != -1) {
                User.setIdCount(count + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        try (var stream = Files.lines(Path.of(FILE_NAME))) {
            return stream.map(line -> {
                        String[] arrayUser = line.split("\\|");
                        return new User(Integer.parseInt(arrayUser[0]), arrayUser[1], arrayUser[2],
                                Integer.parseInt(arrayUser[3]), Boolean.parseBoolean(arrayUser[4]));
                    }).filter(user -> id == user.getId())
                    .findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(forAdd(user));
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String forAdd(User user) {
        var sb = new StringBuilder();
        var string = sb.append(user.getId()).append("|")
                .append(user.getName()).append("|")
                .append(user.getLastName()).append("|")
                .append(user.getAge()).append("|")
                .append(user.isEmployed()).append('\n');
        return String.valueOf(string);
    }

    @Override
    public void update(User userUpdate) {
        try (var stream = Files.lines(Path.of(FILE_NAME))) {
            int id = userUpdate.getId() - 1;
            List<User> arrayUser = stream.map(line -> {
                String[] arrayUsers = line.split("\\|");
                return new User(Integer.parseInt(arrayUsers[0]), arrayUsers[1], arrayUsers[2],
                        Integer.parseInt(arrayUsers[3]), Boolean.parseBoolean(arrayUsers[4]));
            }).collect(toList());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, false));
            for (User user : arrayUser) {
                if (user.getId() == id) {
                    arrayUser.set(id, userUpdate);
                }
                bufferedWriter.write(forAdd(user));
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (var stream = Files.lines(Path.of(FILE_NAME))) {
            List<User> arrayUser = stream
                    .map(line -> {
                        String[] arrayUsers = line.split("\\|");
                        return new User(Integer.parseInt(arrayUsers[0]), arrayUsers[1], arrayUsers[2],
                                Integer.parseInt(arrayUsers[3]), Boolean.parseBoolean(arrayUsers[4]));
                    }).filter(user -> user.getId() != id).collect(toList());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, false));
            for (User user : arrayUser) {
                bufferedWriter.write(forAdd(user));
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}