package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.console.util.Writer;
import by.AndreiKviatkouski.console.validator.TelephoneValidator;
import by.AndreiKviatkouski.console.validator.UserValidator;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.service.UserServiceImpl;

import java.util.List;

import static by.AndreiKviatkouski.console.util.Reader.*;
import static by.AndreiKviatkouski.console.util.Writer.writeObject;
import static by.AndreiKviatkouski.console.util.Writer.writeString;


public class UserActionImpl implements UserAction {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void save() throws AddRoleException {
        writeString("Enter FirstName");
        String firstName = readLine();
        while (!UserValidator.validName(firstName)) {
            writeString("Invalid firstName: " + firstName + "\n" + "Try again! Enter FirstName:");
            firstName = readLine();
        }
        writeString("Enter LastName");
        String lastName = readLine();
        while (!UserValidator.validName(lastName)) {
            writeString("Invalid LastName" + lastName + "\n" + "Try again! Enter LastName:");
            lastName = readLine();
        }
        writeString("Enter email (example:xxx@xx.xxx)");
        String email = readLine();
        while (!UserValidator.validEmail(email)) {
            writeString("Invalid email" + email + "\n" + "Try again! Enter email:");
            email = readLine();
        }
        if (userService.checkEmail(email)) {
            System.err.println("User with email exist: " + email + "\n");
            return;
        }
        writeString("Enter home phone number (example:+8017-XXX-XX-XX or 8017XXXXXXX)");
        String homeNumber = readLine();
        while (!TelephoneValidator.validHomeTelephone(homeNumber)) {
            writeString("Invalid number" + homeNumber + "\n" + "Try again! Enter home number:");
            homeNumber = readLine();
        }
        writeString("Enter home phone number (example:+375-XX-XXX-XX-XX or 375XXXXXXXXX)");
        String mobileNumber = readLine();
        while (!TelephoneValidator.validTelephone(mobileNumber)) {
            writeString("Invalid number" + mobileNumber + "\n" + "Try again! Enter mobile number:");
            mobileNumber = readLine();
        }

        if (userService.checkUser(mobileNumber)) {
            System.err.println("User with mobile number exist: " + mobileNumber + "\n");
            return;
        }

        Telephone telephone = new Telephone(homeNumber, mobileNumber);
        User user = new User(firstName, lastName, email, telephone);
        user.addRole(new Role(Role.USER));
        user.addRole(new Role(Role.ADMIN));

        userService.save(user);
        writeString("Creation is successful" + user + "\n");

        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserLastNameById() throws UserException, AddRoleException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,");
            id = readId();
        }
        writeString("Enter new LastName");
        String lastName = readLine();
        while (!UserValidator.validName(lastName)) {
            writeString("Invalid lastName: " + lastName + "\n" + "Try again! Enter LastName:");
            lastName = readLine();
        }
        User user = userService.getById(id);
        user.setLastName(lastName);
        userService.update(id, user);
        writeString("User's lastName was updated:" + lastName + "\n");
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void updateUserFirstNameById() throws UserException, AddRoleException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,:");
            id = readId();
        }
        writeString("Enter new FirstName");
        String firstName = readLine();
        while (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName: " + firstName + "\n" + "Try again! Enter FirstName:");
            firstName = readLine();
        }
        User user = userService.getById(id);
        userService.update(id, user);
        user.setFirstName(firstName);
        writeString("User's firstName was updated:" + firstName + "\n");
        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserEmailById() throws UserException, AddRoleException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,:");
            id = readId();
        }
        writeString("Enter new email");
        String email = readLine();
        while (!UserValidator.validEmail(email)) {
            writeString("Invalid email: " + email + "\n" + "Try again! Enter email:");
            email = readLine();
        }
        if (userService.checkEmail(email)) {
            System.err.println("User with email exist: " + email + "\n");
            return;
        }

        User user = userService.getById(id);
        userService.update(id, user);
        user.setEmail(email);
        writeString("User's email was updated:" + email + "\n");
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void updateUserTelephonesById() throws UserException, AddRoleException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,:");
            id = readId();
        }

        writeString("Enter new home phone number (example:+8017-XXX-XX-XX or 8017XXXXXXX)");
        String homeNumber = readLine();

        while (!TelephoneValidator.validHomeTelephone(homeNumber)) {
            writeString("Invalid number.Try again! Enter home number:");
            homeNumber = readLine();
        }
        writeString("Enter new mobile phone number (example:+375-XX-XXX-XX-XX or 375XXXXXXXXX)");
        String mobileNumber = readLine();

        while (!TelephoneValidator.validTelephone(mobileNumber)) {
            writeString("Invalid number.Try again! Enter mobile number:" + "\n");
            mobileNumber = readLine();
        }
        if (userService.checkUser(mobileNumber)) {
            System.err.println("User with mobile number exist: " + mobileNumber + "\n");
            return;
        }
        Telephone telephone = new Telephone(homeNumber, mobileNumber);

        User user = userService.getById(id);
        userService.update(id, user);
        user.setTelephone(telephone);
        writeString("User's " + userService.getById(id).getLastName() + " telephone was updated:" + "home number: " + telephone.getHomeNumber() + " mobile number: " + telephone.getMobileNumber());
        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserRoleById() throws UserException, AddRoleException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,:");
            id = readId();
        }
        writeString("Chose role: 1 - SUPER_ADMIN, 2 - USER + ADMIN, 3 - USER + PROVIDER, 4 - CUSTOMER + ADMIN, 5 - CUSTOMER + PROVIDER");
        int role = readInt();
        while (!UserValidator.validId(role)) {
            writeString("Invalid role: " + role + "\n" + "Try again! Enter Role:");
            role = readInt();
        }

        switch (role) {

            case 1 -> {
                new Role(Role.SUPER_ADMIN);
            }
            case 2 -> {
                new Role(Role.USER);
                new Role(Role.ADMIN);
            }
            case 3 -> {
                new Role(Role.USER);
                new Role(Role.PROVIDER);
            }
            case 4 -> {
                new Role(Role.CUSTOMER);
                new Role(Role.ADMIN);
            }
            case 5 -> {
                new Role(Role.CUSTOMER);
                new Role(Role.PROVIDER);
            }
            default -> writeString("Set default role USER " + "\n");

        }
        User user = userService.getById(id);
        userService.update(id, user);
        user.addRole(new Role(role));
        writeString("User's role was successfully updated!");
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void removeById() throws UserException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,");
            id = readId();
        }
        userService.remove(id);
        writeString("User was deleted" + "\n");
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void getById() throws UserException {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again! Enter Id:");
            id = readId();
        }
        userService.getById(id);
        writeString("The user is found: " + userService.getById(id) + "\n");
    }


    @Override
    public void getUserByLastName() throws UserException {
        Writer.writeString("Enter LastName");
        String lastName = readLine();
        while (!UserValidator.validName(lastName)) {
            writeString("Invalid LastName" + "\n" + "Try again! Enter LastName:");
            lastName = readLine();
        }
        List<User> userList = userService.getUserByLastName(lastName);

        writeString("The user is found:");
        for (User user : userList) {
            writeObject(user);
        }
    }


    @Override
    public void getUserByFirstName() throws UserException {
        Writer.writeString("Enter FirstName");
        String firstName = readLine();
        while (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName" + "\n" + "Try again! Enter FirstName:");
            firstName = readLine();
        }
        List<User> userList = userService.getUserByFirstName(firstName);

        writeString("The user is found:");
        for (User user : userList) {
            writeObject(user);
        }
    }

    @Override
    public void getAll() {
        List<User> all = userService.getAll();
        for (int i = 0; i < all.size(); i++) {
            writeString((i + 1) + " " + all.get(i).getFirstName() + " " + all.get(i).getLastName() + " " + all.get(i).getRoles() + " email: " + all.get(i).getEmail() + " home phone: " + all.get(i).getTelephone().getHomeNumber() + " mobile phone: " + all.get(i).getTelephone().getMobileNumber());
        }
    }
}
