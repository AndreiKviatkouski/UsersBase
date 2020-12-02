package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

public interface UserStorage {

    boolean save(User user);

    User updateUserByLastName(int id, String lastName);
    User updateUserByFirstName(int id, String firstName);
    User updateUserByEmail(int id, String email);
    User updateUserByTelephone(int id, Telephone telephone);
    User updateUserByRole(int id, Role role);


    void remove(int id);
    void remove(User user);

    User getById(int id);
    User getUserByLastName(String lastName);
    User getUserByFirstName(String firstName);
    User[] getAll();

    boolean contains(User user);
    boolean contains(int id);
    boolean contains(String lastName);
    boolean contains(String firstName, String lastName);
}
