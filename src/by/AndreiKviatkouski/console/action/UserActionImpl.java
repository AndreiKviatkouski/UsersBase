package by.AndreiKviatkouski.console.action;

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
import static by.AndreiKviatkouski.console.util.Writer.writeString;


public class UserActionImpl implements UserAction {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void save() {
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
        user.setRole(Role.USER);
        userService.save(user);
        writeString("Creation is successful" + user + "\n");

        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserLastNameById() {
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
        try {
            userService.updateUserByLastName(id, lastName);
            writeString("User's lastName was updated:" + lastName + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void updateUserFirstNameById() {
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
        try {
            userService.updateUserByFirstName(id, firstName);
            writeString("User's firstName was updated:" + firstName + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserEmailById() {
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
        try {
            userService.updateUserByEmail(id, email);
            writeString("User's email was updated:" + email + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void updateUserTelephonesById() {
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
        try {
            userService.updateUserByTelephone(id, telephone);
            writeString("User's " + userService.getById(id).getLastName() + " telephone was updated:" + "home number: " + telephone.getHomeNumber() + " mobile number: " + telephone.getMobileNumber());
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
        Writer.writeUserToFile(userService.getAll());
    }

    @Override
    public void updateUserRoleById() {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,:");
            id = readId();
        }
        writeString("Chose role: 1 - ADMIN, 2 - MODERATOR, 3 - USER");
        int role = readInt();
        while (!UserValidator.validId(role)) {
            writeString("Invalid role: " + role + "\n" + "Try again! Enter Role:");
            role = readInt();
        }
        try {
            switch (role) {
                case 1 -> userService.updateUserByRole(id, Role.ADMIN);
                case 2 -> userService.updateUserByRole(id, Role.MODERATOR);
                case 3 -> userService.updateUserByRole(id, Role.USER);
                default -> writeString("Set default role USER " + "\n");

            }
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
        writeString("User's role was successfully updated!");
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void removeById() {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again,");
            id = readId();
        }
        try {
            userService.remove(id);
            writeString("User was deleted" + "\n");
        }catch (UserException e){
            System.err.println("Id not found!");
        }
            Writer.writeUserToFile(userService.getAll());
        }


    @Override
    public void removeUser() {
        for (int i = 0; i < userService.getAll().size(); i++) {
            writeString((i + 1) + " " + userService.getAll().get(i).getLastName());
        }
        int i = readInt() - 1;
        try {
            userService.remove(userService.getAll().get(i));
            writeString("User was deleted!");
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        Writer.writeUserToFile(userService.getAll());
    }


    @Override
    public void getById() {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n" + "Try again! Enter Id:");
            id = readId();
        }
        try {
            userService.getById(id);
            writeString("The user is found: " + userService.getById(id) + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void getUserByLastName() {
        Writer.writeString("Enter LastName");
        String lastName = readLine();
        while (!UserValidator.validName(lastName)) {
            writeString("Invalid LastName" + "\n" + "Try again! Enter LastName:");
            lastName = readLine();
        }
        try {
            userService.getUserByLastName(lastName);
            writeString("The user is found: " + userService.getUserByLastName(lastName) + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void getUserByFirstName() {
        Writer.writeString("Enter FirstName");
        String firstName = readLine();
        while (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName" + "\n" + "Try again! Enter FirstName:");
            firstName = readLine();
        }
        try {
            userService.getUserByFirstName(firstName);
            writeString("The user is found: " + userService.getUserByFirstName(firstName) + "\n");
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        List<User> all = userService.getAll();
        for (int i = 0; i < all.size(); i++) {
            writeString((i + 1) + " " + all.get(i).getFirstName() + " " + all.get(i).getLastName() + " " + all.get(i).getRole() + " email: " + all.get(i).getEmail() + " home phone: " + all.get(i).getTelephone().getHomeNumber() + " mobile phone: " + all.get(i).getTelephone().getMobileNumber());
        }
    }
}
