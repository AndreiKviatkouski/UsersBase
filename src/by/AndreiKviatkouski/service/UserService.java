package by.AndreiKviatkouski.service;


import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.console.exception.UserException;

import java.util.List;


public interface UserService {
    boolean save(User user);

    void update(User user) throws UserException, AddRoleException;

    void remove(long id) throws UserException;

    List<User> getUserByParams(User user) throws UserException;
    User getById(long id) throws UserException;
    List<User> getAll();


    boolean checkUser(String mobileNumber);
    boolean checkEmail(String email);

}
