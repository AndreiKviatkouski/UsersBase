package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.console.util.Writer;
import by.AndreiKviatkouski.console.validator.TelephoneValidator;
import by.AndreiKviatkouski.console.validator.UserValidator;
import by.AndreiKviatkouski.service.TelephoneServiceImpl;
import by.AndreiKviatkouski.service.UserServiceImpl;

import static by.AndreiKviatkouski.console.util.Reader.*;
import static by.AndreiKviatkouski.console.util.Reader.readLine;
import static by.AndreiKviatkouski.console.util.Writer.writeString;

public class TelephoneActionImpl implements TelephoneAction {
    TelephoneServiceImpl telephoneService = new TelephoneServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();


    @Override
    public void updatePhoneHomeNumberById() {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n");
            id = readId();
        }
        writeString("Enter new home phone number (example:+8017-XXX-XX-XX or 8017XXXXXXX)");
        String homeNumber = readLine();
        while (!TelephoneValidator.validHomeTelephone(homeNumber)) {
            writeString("Invalid number" + homeNumber + "\n" + "Try again! Enter home number:");
            homeNumber = readLine();
        }
        try {
            telephoneService.updateHomeNumberByUserId(id, homeNumber);
            writeString("The update was successfully.New number: " + homeNumber + "\n");
        } catch (TelephoneException e) {
            System.err.println(e.getMessage());
        }

        Writer.writeUserToFile(userService.getAll());
    }



    @Override
    public void updatePhoneMobileNumberById() {
        long id = readId();
        while (!UserValidator.validId(id)) {
            writeString("Invalid ID: " + id + "\n");
            id = readId();
        }
        writeString("Enter new mobile phone number (example:+375-XX-XXX-XX or 375XXXXXXXXX)");
        String mobileNumber = readLine();
        while (!TelephoneValidator.validTelephone(mobileNumber)) {
            writeString("Invalid number" + mobileNumber + "\n" + "Try again! Enter mobile number:");
            mobileNumber = readLine();
        }
        if (userService.checkUser(mobileNumber)) {
            System.err.println("User with mobile number exist: " + mobileNumber + "\n");
            return;
        }
        try {
            telephoneService.updateMobileNumberByUserId(id, mobileNumber);
            writeString("The update was successfully.New number:    " + mobileNumber + "\n");
        } catch (TelephoneException e) {
            System.err.println(e.getMessage());
        }

        Writer.writeUserToFile(userService.getAll());
    }
}
