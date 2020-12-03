package by.AndreiKviatkouski.console;

import by.AndreiKviatkouski.console.action.TelephoneActionImpl;
import by.AndreiKviatkouski.console.action.UserActionImpl;

import static by.AndreiKviatkouski.console.util.Reader.readInt;
import static by.AndreiKviatkouski.console.util.Writer.writeString;

public class ConsoleApplication {

    private final UserActionImpl userAction = new UserActionImpl();
    private final TelephoneActionImpl telephoneAction = new TelephoneActionImpl();

    public void run() {
        while (true) {
            showUserMenu();
            switch (readInt()) {
                case 0:
                    showGetUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.getAll();
                            break;
                        case 2:
                            userAction.getById();
                            break;
                        case 3:
                            userAction.getUserByFirstName();
                            break;
                        case 4:
                            userAction.getUserByLastName();
                            break;
                        case 5:
                            telephoneAction.getAllPhones();
                            break;
                        case 6:
                            telephoneAction.getPhoneByHomeNumber();
                            break;
                        case 7:
                            telephoneAction.getPhoneMobileNumber();
                            break;
                        case 8:
                            telephoneAction.getPhoneById();
                            break;
                        default:
                            writeString("Operation not found");
                            break;
                    }
                case 1:
                    showRemoveUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.removeUser();
                            break;
                        case 2:
                            userAction.removeById();
                            break;
                        case 3:
                            telephoneAction.removeById();
                            break;
                        case 4:
                            telephoneAction.removeByMobileNumber();
                            break;
                        case 5:
                            telephoneAction.removeByHomeNumber();
                            break;
                        default:
                            writeString("Operation not found");
                            continue;
                    }
                    break;
                case 2:
                    showUpdateUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.updateUserByEmail();
                            break;
                        case 2:
                            userAction.updateUserByFirstName();
                            break;
                        case 3:
                            userAction.updateUserByLastName();
                            break;
                        case 4:
                            userAction.updateUserByRole();
                            break;
                        case 5:
                            userAction.updateUserByTelephone();
                            break;
                        case 6:
                            telephoneAction.updatePhoneByMobileNumber();
                            break;
                        case 7:
                            telephoneAction.updatePhoneByHomeNumber();
                            break;
                        default:
                            writeString("Operation not found");
                            continue;
                    }
                case 3:
                    showSaveUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.save();
                            break;
                        case 2:
                            telephoneAction.save();
                            break;
                        default:
                            writeString("Operation not found");
                            continue;
                    }
                default:
                    writeString("Operation not found");
                    break;
            }
        }
    }
    private void showUserMenu() {
        writeString("!!!!! USER MENU!!!!!");
        writeString("0  - GET USER MENU");
        writeString("1  - REMOVE USER MENU");
        writeString("2  - UPDATE USER MENU");
        writeString("3  - SAVE USER MENU");

    }

    private void showGetUserMenu() {
        writeString("!!!!!GET USER MENU!!!!!");
        writeString("0  - Logout");
        writeString("1  - get all user");
        writeString("2  - get user by id");
        writeString("3  - get user by firstname");
        writeString("4  - get user by lastname");
        writeString("5  - get all user's telephones");
        writeString("5  - get user's home telephone");
        writeString("5  - get user's mobile telephone");
        writeString("5  - get user's telephone by id");
    }

    private void showRemoveUserMenu() {
        writeString("!!!!!GET USER MENU!!!!!");
        writeString("0  - Logout");
        writeString("1  - remove user");
        writeString("2  - remove user by Id");
        writeString("3  - remove phone by Id");
        writeString("4  - remove phone by mobile number");
        writeString("5  - remove phone by home number");
    }

    private void showUpdateUserMenu() {
        writeString("!!!!!UPDATE USER MENU!!!!!");
        writeString("0  - Logout");
        writeString("1  - update user email ");
        writeString("2  - update user firstname");
        writeString("3  - update user lastname");
        writeString("4  -update user role ");
        writeString("5  -update user phone ");
        writeString("6  -update user mobile number ");
        writeString("7  -update user home number ");
    }
    private void showSaveUserMenu() {
        writeString("!!!!!Save USER MENU!!!!!");
        writeString("0  - Logout");
        writeString("1  -  save user");
        writeString("2  - save telephones ");

    }
}