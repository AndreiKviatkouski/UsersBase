package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
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
    public void updateUserByLastName(long id, String lastName) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.updateUserByLastName(id, lastName);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public void updateUserByFirstName(long id, String firstName) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.updateUserByFirstName(id, firstName);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public void updateUserByEmail(long id, String email) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.updateUserByEmail(id, email);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public void updateUserByTelephone(long id, Telephone telephone) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.updateUserByTelephone(id, telephone);
            return;
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public void updateUserByRole(long id, Role role) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.updateUserByRole(id, role);
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
    public void remove(User user) {
        if (userStorage.contains(user)) {
            userStorage.remove(user);
        }
    }

    @Override
    public User getById(long id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public User getUserByLastName(String lastName) throws UserException {
        if (userStorage.contains(lastName)) {
            return userStorage.getUserByLastName(lastName);
        }
        throw new UserException("Could not find user with LastName: " + lastName);
    }

    @Override
    public User getUserByFirstName(String firstName) throws UserException {
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
