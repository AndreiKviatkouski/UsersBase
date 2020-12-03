package by.AndreiKviatkouski.service;


import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.console.exception.UserException;

public interface UserService {
    boolean save(User user);

    User updateUserByLastName(int id, String lastName) throws UserException;
    User updateUserByFirstName(int id, String firstName) throws UserException;
    User updateUserByEmail(int id, String email) throws UserException;
    User updateUserByTelephone(int id, Telephone telephone) throws UserException;
    User updateUserByRole(int id, Role role) throws UserException;


    void remove(int id) throws UserException;
    void remove(User user) throws UserException;

    User getById(int id) throws UserException;
    User getUserByLastName(String lastName);
    User getUserByFirstName(String firstName);
    User[] getAll();

    User checkUser(String mobileNumber);

}
