package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;

public interface UserAction {
    void save() throws AddRoleException;

    void updateUserLastNameById() throws UserException, AddRoleException;
    void updateUserFirstNameById() throws UserException, AddRoleException;
    void updateUserEmailById() throws UserException, AddRoleException;
    void updateUserTelephonesById() throws UserException, AddRoleException;
    void updateUserRoleById() throws UserException, AddRoleException;

    void removeById() throws UserException;
    void getById() throws UserException;
    void getUserByLastName() throws UserException;
    void getUserByFirstName() throws UserException;
    void getAll();
}
