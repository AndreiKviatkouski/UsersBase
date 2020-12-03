package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.console.exception.UserException;
import by.AndreiKviatkouski.console.util.Writer;
import by.AndreiKviatkouski.console.validator.TelephoneValidator;
import by.AndreiKviatkouski.console.validator.UserValidator;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.service.UserServiceImpl;


import static by.AndreiKviatkouski.console.util.Reader.readInt;
import static by.AndreiKviatkouski.console.util.Reader.readString;
import static by.AndreiKviatkouski.console.util.Writer.writeString;

public class UserActionImpl implements UserAction {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void save() {
        writeString("Enter FirstName");
        String firstName = readString();
        if (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName");
            return;
        }
        writeString("Enter LastName");
        String lastName = readString();
        if (!UserValidator.validName(lastName)) {
            writeString("Invalid LastName");
            return;
        }
        writeString("Enter email (example:xxx@xx.xxx)");
        String email = readString();
        if (!UserValidator.validEmail(email)) {
            writeString("Invalid email");
            return;
        }
        writeString("Enter home phone number (example:+8017-XXX-XX-XX or 8017XXXXXXX");
        String homeNumber = readString();
        if (!TelephoneValidator.validHomeTelephone(homeNumber)) {
            writeString("Invalid number");
            return;
        }
        writeString("Enter home phone number (example:+375-XX-XXX-XX-XX or 375XXXXXXXXX");
        String mobileNumber = readString();
        if (!TelephoneValidator.validTelephone(mobileNumber)) {
            writeString("Invalid number");
            return;
        }
        Telephone telephone = new Telephone(homeNumber, mobileNumber);
        User user = new User(firstName, lastName, email, telephone);
        user.setRole(Role.USER);
        userService.save(user);
        writeString("Creation is successful");
    }

    @Override
    public void updateUserByLastName() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter new LastName");
        String lastName = readString();
        if (!UserValidator.validName(lastName)) {
            writeString("Invalid lastName: " + lastName);
            return;
        }
        try {
            userService.updateUserByLastName(id, lastName);
            writeString("User's lastName was updated:" + lastName);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }


    @Override
    public void updateUserByFirstName() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter new FirstName");
        String firstName = readString();
        if (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName: " + firstName);
            return;
        }
        try {
            userService.updateUserByFirstName(id, firstName);
            writeString("User's firstName was updated:" + firstName);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void updateUserByEmail() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter new email");
        String email = readString();
        if (!UserValidator.validEmail(email)) {
            writeString("Invalid email: " + email);
            return;
        }
        try {
            userService.updateUserByEmail(id, email);
            writeString("User's email was updated:" + email);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }


    @Override
    public void updateUserByTelephone() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Enter home phone number (example:+8017-XXX-XX-XX or 8017XXXXXXX");
        String homeNumber = readString();

        if (!TelephoneValidator.validHomeTelephone(homeNumber)) {
            writeString("Invalid number");
            return;
        }
        writeString("Enter home phone number (example:+375-XX-XXX-XX-XX or 375XXXXXXXXX");
        String mobileNumber = readString();

        if (!TelephoneValidator.validTelephone(mobileNumber)) {
            writeString("Invalid number");
            return;
        }
        Telephone telephone = new Telephone(homeNumber, mobileNumber);
        try {
            userService.updateUserByTelephone(id, telephone);
            writeString("User's telephone was updated:" + telephone);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateUserByRole() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        writeString("Chose role: 1 - ADMIN, 2 - MODERATOR, 3 - USER");
        int role = readInt();
        if (!UserValidator.validId(role)) {
            writeString("Invalid role: " + role);
            return;
        }
        try {
            switch (role) {
                case 1:
                    userService.updateUserByRole(id, Role.ADMIN);
                    break;
                case 2:
                    userService.updateUserByRole(id, Role.MODERATOR);
                    break;
                case 3:
                    userService.updateUserByRole(id, Role.USER);
                    break;
                default:
                    writeString("Set default role USER ");
            }
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }




    @Override
    public void removeById() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        try {
            userService.remove(id);
            writeString("Store was deleted: " + userService.getById(id));
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void removeUser() {
        User[] all = userService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getLastName());
        }
        int i = readInt() - 1;
        User user = all[i];
        try {
            userService.remove(user);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
        writeString("User was deleted: " + user);

    }


    @Override
    public void getById() {
        writeString("Enter id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id);
            return;
        }
        try {
            userService.getById(id);
            writeString("Your finding user is: " + userService.getById(id));
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void getUserByLastName() {
        Writer.writeString("Enter Id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Writer.writeString("Enter new LastName");
        String lastName = readString();
        if (!UserValidator.validName(lastName)) {
            writeString("Invalid LastName");
        }
        try {
            userService.updateUserByLastName(id, lastName);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void getUserByFirstName() {
        Writer.writeString("Enter Id");
        int id = readInt();
        if (!UserValidator.validId(id)) {
            writeString("Invalid id");
            return;
        }
        Writer.writeString("Enter new FirstName");
        String firstName = readString();
        if (!UserValidator.validName(firstName)) {
            writeString("Invalid FirstName");
        }
        try {
            userService.updateUserByFirstName(id, firstName);
        } catch (UserException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void getAll() {
        User[] all = userService.getAll();
        for (int i = 0; i < all.length; i++) {
            writeString((i + 1) + " " + all[i].getFirstName() + " " + all[i].getLastName());
        }
    }
}
