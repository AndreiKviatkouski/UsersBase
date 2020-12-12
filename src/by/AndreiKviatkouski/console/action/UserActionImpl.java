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
        user.addRole(new Role(Role.USER_level,Role.USER_str));
        user.addRole(new Role(Role.ADMIN_level,Role.ADMIN_str));

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
        User user = new User();
        user.setLastName(lastName);
        user.setId(id);
        userService.update(user);
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
        User user = new User();
        user.setFirstName(firstName);
        user.setId(id);
        userService.update(user);
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

        User user = new User();
        user.setEmail(email);
        user.setId(id);
        userService.update(user);

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

        User user = new User();
        user.setTelephone(telephone);
        user.setId(id);
        userService.update(user);

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
        writeString("Valid value: SUPER_ADMIN, USER + ADMIN, USER + PROVIDER,  CUSTOMER + ADMIN,  CUSTOMER + PROVIDER");
        writeString("Chose first role: 1 - SUPER_ADMIN, 2 - USER, 3  - CUSTOMER");
        int number = readInt();
        User user = new User();

        switch (number) {
            case 1 -> user.addRole(new Role(Role.SUPER_ADMIN_level,Role.SUPER_ADMIN_str));
            case 2 -> user.addRole(new Role(Role.USER_level,Role.USER_str));
            case 3 -> user.addRole(new Role(Role.CUSTOMER_level,Role.CUSTOMER_str));
            default -> throw new UserException("Operation not found!");
        }

        writeString("Chose second role: 1 - ADMIN , 2  - PROVIDER");
        number = readInt();
        switch (number) {
            case 1 -> user.addRole(new Role(Role.ADMIN_level,Role.ADMIN_str));
            case 2 -> user.addRole(new Role(Role.PROVIDER_level,Role.PROVIDER_str));
            default -> writeString("Operation not found!" + "\n");
        }
        user.setId(id);
        userService.update(user);
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
        User userNew = new User();
        userNew.setLastName(lastName);
        List<User> userList = userService.getUserByParams(userNew);
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
        User userNew = new User();
        userNew.setFirstName(firstName);
        List<User> userList = userService.getUserByParams(userNew);
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
