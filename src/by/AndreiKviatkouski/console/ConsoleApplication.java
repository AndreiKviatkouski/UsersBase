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
                    return;
                case 1:
                    showGetUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.getAll();
                            continue;
                        case 2:
                            userAction.getById();
                            continue;
                        case 3:
                            userAction.getUserByFirstName();
                            continue;
                        case 4:
                            userAction.getUserByLastName();
                            continue;
                        default:
                            writeString("Operation not found");
                            continue;
                    }
                case 2:
                    showRemoveUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.removeUser();
                            continue;
                        case 2:
                            userAction.removeById();
                            continue;
                        default:
                            writeString("Operation not found");
                           continue;
                    }


                case 3:
                    showUpdateUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.updateUserEmailById();
                            continue;
                        case 2:
                            userAction.updateUserFirstNameById();
                            continue;
                        case 3:
                            userAction.updateUserLastNameById();
                            continue;
                        case 4:
                            userAction.updateUserRoleById();
                            continue;
                        case 5:
                            userAction.updateUserTelephonesById();
                            continue;
                        case 6:
                            telephoneAction.updatePhoneMobileNumberById();
                            continue;
                        case 7:
                            telephoneAction.updatePhoneHomeNumberById();
                            continue;
                        default:
                            writeString("Operation not found");
                           continue;
                    }
                case 4:
                    showSaveUserMenu();
                    switch (readInt()) {
                        case 0:
                            continue;
                        case 1:
                            userAction.save();
                            continue;
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
        writeString("!!!!! USER MENU!!!!!" + "\n");
        writeString("0  - Exit");
        writeString("1  - GET USER MENU");
        writeString("2  - REMOVE USER MENU");
        writeString("3  - UPDATE USER MENU");
        writeString("4  - SAVE USER MENU" + "\n");

    }

    private void showGetUserMenu() {
        writeString("!!!!!GET USER MENU!!!!!" + "\n");
        writeString("0  - Logout");
        writeString("1  - get all user");
        writeString("2  - get user by id");
        writeString("3  - get user by firstname");
        writeString("4  - get user by lastname" + "\n");

    }

    private void showRemoveUserMenu() {
        writeString("!!!!!GET USER MENU!!!!!" + "\n");
        writeString("0  - Logout");
        writeString("1  - remove user");
        writeString("2  - remove user by Id" + "\n");

    }

    private void showUpdateUserMenu() {
        writeString("!!!!!UPDATE USER MENU!!!!!" + "\n");
        writeString("0  - Logout");
        writeString("1  - update user email by id ");
        writeString("2  - update user firstname by id");
        writeString("3  - update user lastname by id");
        writeString("4  - update user role by id");
        writeString("5  - update user phones by id");
        writeString("6  - update user mobile number by id ");
        writeString("7  - update user home number by id " + "\n");
    }

    private void showSaveUserMenu() {
        writeString("!!!!!Save USER MENU!!!!!" + "\n");
        writeString("0  - Logout");
        writeString("1  - save user" + "\n");
    }
}