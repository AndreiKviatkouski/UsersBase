package by.AndreiKviatkouski;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

import java.io.*;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Telephone telephone = new Telephone("8017-100-00-00", "+375-00-100-00-00");
        Telephone telephone2 = new Telephone("8017-100-00-00", "+375-00-100-00-00");
        User user1 = new User(1, "Cho", "Li", "li@li.com", Role.ADMIN, telephone);
        User user2 = new User(1, "Han", "Lun", "lun@li.com", Role.USER, telephone2);

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);


        try {
            FileOutputStream fos = new FileOutputStream(new File("JavaObjectsTest.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (User user : list) {
                oos.writeObject(user + "\n");
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fis = new FileInputStream("JavaObjectsTest.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    list.add((User) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (User user : list) {
            System.out.println(user);
        }

    }
}




