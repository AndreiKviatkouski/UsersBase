package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

import java.util.List;

public interface UserStorage {

    boolean save(User user);

    void updateUserByLastName(long id, String lastName);
    void updateUserByFirstName(long id, String firstName);
    void updateUserByEmail(long id, String email);
    void updateUserByTelephone(long id, Telephone telephone);
    void updateUserByRole(long id, Role role);

    void remove(long id);
    void remove(User user);

    User getById(long id);
    User getUserByLastName(String lastName);
    User getUserByFirstName(String firstName);
    List<User> getAll();

    boolean contains(User user);
    boolean contains(long id);
    boolean contains(String lastName);
    boolean containsFirstName(String firstName);
    boolean containsEmail (String email);
}
