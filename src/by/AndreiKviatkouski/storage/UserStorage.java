package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.domain.User;

import java.util.List;


public interface UserStorage {

    boolean save(User user);

    User update(long id, User user)throws UserException, AddRoleException;

    void remove(long id);


    List<User> getUserByParams(User user);
    User getById(long id);
    List<User> getAll();

    boolean contains(User user);
    boolean contains(long id);
    boolean containsLastName(String lastName);
    boolean containsFirstName(String firstName);
    boolean containsEmail(String email);
}
