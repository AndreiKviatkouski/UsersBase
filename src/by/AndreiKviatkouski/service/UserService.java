package by.AndreiKviatkouski.service;


import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.console.exception.UserException;

import java.util.List;

public interface UserService {
    boolean save(User user);

    void updateUserByLastName(long id, String lastName) throws UserException;
    void updateUserByFirstName(long id, String firstName) throws UserException;
    void updateUserByEmail(long id, String email) throws UserException;
    void updateUserByTelephone(long id, Telephone telephone) throws UserException;
    void updateUserByRole(long id, Role role) throws UserException;


    void remove(long id) throws UserException;
    void remove(User user);

    User getById(long id) throws UserException;
    User getUserByLastName(String lastName) throws UserException;
    User getUserByFirstName(String firstName) throws UserException;
    List<User> getAll();

    boolean checkUser(String mobileNumber);
    boolean checkEmail(String email);

}
