package by.AndreiKviatkouski.service;


import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.console.exception.UserException;

import java.util.List;
import java.util.Set;

public interface UserService {
    boolean save(User user);

    void update(long id, User user) throws UserException, AddRoleException;

    void remove(long id) throws UserException;

    List<User> getUserByParams(User user) throws UserException;
    User getById(long id) throws UserException;
    List<User> getAll();


    boolean checkUser(String mobileNumber);
    boolean checkEmail(String email);

}
