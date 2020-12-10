package by.AndreiKviatkouski.service;


import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.console.exception.UserException;

import java.util.List;

public interface UserService {
    boolean save(User user);

    void update(long id, User user) throws UserException, AddRoleException;

    void remove(long id) throws UserException;


    User getById(long id) throws UserException;
    List<User> getUserByLastName(String lastName) throws UserException;
    List<User> getUserByFirstName(String firstName) throws UserException;
    List<User> getAll();

    boolean checkUser(String mobileNumber);
    boolean checkEmail(String email);

}
