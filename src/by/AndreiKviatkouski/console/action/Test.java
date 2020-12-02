package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.storage.TelephoneStorageImpl;

import java.io.*;

public class Test {

    public static void main(String[] args) {
        TelephoneStorageImpl telephoneStorage = new TelephoneStorageImpl();
        User user1 = new User(1, "Andrew", "Li", "li@li.com", Role.ADMIN, telephoneStorage.getPhoneById(2));
        User user2 = new User(1, "Andrew", "Li", "li@li.com", Role.ADMIN, telephoneStorage.getPhoneById(2));

        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\JavaObjects.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Запись объектов в файл
            oos.writeObject(user1);
            oos.writeObject(user2);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Чтение объектов из файла
        try {
            FileInputStream fis = new FileInputStream(new File("D:\\JavaObjects.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            User s1 = (User) ois.readObject();
            User s2 = (User) ois.readObject();
            System.out.println(s1.toString());
            System.out.println(s2.toString());
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

