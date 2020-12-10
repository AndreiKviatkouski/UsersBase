package by.AndreiKviatkouski.console.util;

import by.AndreiKviatkouski.domain.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Writer {
    public static void writeString(String str) {
        System.out.println(str);
    }

    public static void writeObject(Object o) {
        System.out.println(o);
    }

    public static void writeUserToFile(List<User> users) {
        try {
            FileOutputStream fos = new FileOutputStream("JavaObjects.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (User user : users) {
                oos.writeObject(user + "\n");
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
