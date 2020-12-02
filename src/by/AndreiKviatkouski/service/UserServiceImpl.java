package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.storage.UserStorageImpl;

public class UserServiceImpl implements UserService {

   UserStorageImpl userStorage = new UserStorageImpl();

    @Override
    public boolean save(User user) {
            if (userStorage.contains(user)) {
                return false;
            }
            userStorage.save(user);
            return true;
        }


    @Override
    public User updateUserByLastName(int id, String lastName) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.updateUserByLastName(id,lastName);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public User updateUserByFirstName(int id, String firstName) throws UserException {
        if (userStorage.contains(id)){
            return userStorage.updateUserByFirstName(id,firstName);
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public User updateUserByEmail(int id, String email) throws UserException {
        if (userStorage.contains(id)){
            return userStorage.updateUserByEmail(id,email);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public User updateUserByTelephone(int id, Telephone telephone) throws UserException {
        if (userStorage.contains(id)){
            return userStorage.updateUserByTelephone(id,telephone);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public User updateUserByRole(int id, Role role) throws UserException {
        if (userStorage.contains(id)){
            return userStorage.updateUserByRole(id,role);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public void remove(int id) throws UserException {
        if (userStorage.contains(id)) {
            userStorage.remove(id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }

    @Override
    public void remove(User user) {
        if (userStorage.contains(user)){
            userStorage.remove(user);
        }

    }

    @Override
    public User getById(int id) throws UserException {
        if (userStorage.contains(id)) {
            return userStorage.getById(id);
        }
        throw new UserException("Could not find user with ID: " + id);
    }


    @Override
    public User getUserByLastName(String lastName) {
        if (userStorage.contains(lastName)) {
            return userStorage.getUserByLastName(lastName);
        }
        return null;
    }

    @Override
    public User getUserByFirstName(String firstName) {
        if (userStorage.contains(firstName)) {
            return userStorage.getUserByFirstName(firstName);
        }
        return null;
    }

    @Override
    public User[] getAll() {
        return userStorage.getAll();
    }

    @Override
    public User checkUser(String mobileNumber) {
        for (User user : userStorage.getAll()) {
            if (user.getTelephone().getMobileNumber().equals(mobileNumber)){
                return user;
            }
        }
        return null;
    }
}
