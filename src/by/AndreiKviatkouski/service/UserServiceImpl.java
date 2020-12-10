package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.storage.TelephoneStorageImpl;
import by.AndreiKviatkouski.storage.UserStorageImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserStorageImpl userStorage = new UserStorageImpl();
    TelephoneStorageImpl telephoneStorage = new TelephoneStorageImpl();

    @Override
    public boolean save(User user) {
        if (userStorage.contains(user)) {
            return false;
        }
        userStorage.save(user);
        return true;
    }


    @Override
    public void update(long id, User user) throws UserException, AddRoleException {
        if (userStorage.contains(id)) {
            userStorage.update(id,user);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }



    @Override
    public void remove(long id) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.remove(id);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public User getById(long id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public List<User> getUserByLastName(String lastName) throws UserException {
        if (userStorage.containsLastName(lastName)) {
            return userStorage.getUserByLastName(lastName);
        }
        throw new UserException("Could not find user with LastName: " + lastName);
    }

    @Override
    public List<User> getUserByFirstName(String firstName) throws UserException {
        if (userStorage.containsFirstName(firstName)) {
            return userStorage.getUserByFirstName(firstName);
        }
        throw new UserException("Could not find user with firstName: " + firstName);
    }

    @Override
    public List<User> getAll() {
        return userStorage.getAll();
    }

    @Override
    public boolean checkUser(String mobileNumber) {
        return telephoneStorage.contains(mobileNumber);
    }

    @Override
    public boolean checkEmail(String email) {
        return userStorage.containsEmail(email);
    }
}
