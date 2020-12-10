package by.AndreiKviatkouski.console;

import by.AndreiKviatkouski.console.action.TelephoneActionImpl;
import by.AndreiKviatkouski.console.action.UserActionImpl;
import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;

import static by.AndreiKviatkouski.console.util.Reader.readInt;
import static by.AndreiKviatkouski.console.util.Writer.writeString;

public class ConsoleApplication {

    private final UserActionImpl userAction = new UserActionImpl();
    private final TelephoneActionImpl telephoneAction = new TelephoneActionImpl();


    public void run() {
        boolean notExit = true;
        while (notExit) {
            showUserMenu();
            switch (readInt()) {
                case 1 -> menuGet();
                case 2 -> menuRemove();
                case 3 -> menuUpdate();
                case 4 -> menuCreate();
                case 0 -> notExit = false;
                default -> writeString("Operation not found");
            }
        }
    }

    public void menuGet() {
        boolean notExit = true;
        while (notExit) {
            showGetUserMenu();
            try {
                switch (readInt()) {
                    case 1 -> userAction.getAll();
                    case 2 -> userAction.getById();
                    case 3 -> userAction.getUserByFirstName();
                    case 4 -> userAction.getUserByLastName();
                    case 0 -> notExit = false;
                    default -> writeString("Operation not found");
                }
            } catch (UserException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menuRemove() {
        boolean notExit = true;
        while (notExit) {
            showRemoveUserMenu();
            try {
                switch (readInt()) {
                    case 1 -> userAction.removeById();
                    case 0 -> notExit = false;
                    default -> writeString("Operation not found");
                }
            } catch (UserException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menuUpdate() {
        boolean notExit = true;
        while (notExit) {
            showUpdateUserMenu();
            try {
                switch (readInt()) {
                    case 1 -> userAction.updateUserEmailById();
                    case 2 -> userAction.updateUserFirstNameById();
                    case 3 -> userAction.updateUserLastNameById();
                    case 4 -> userAction.updateUserRoleById();
                    case 5 -> userAction.updateUserTelephonesById();
                    case 6 -> telephoneAction.updatePhoneHomeNumberById();
                    case 7 -> telephoneAction.updatePhoneMobileNumberById();
                    case 0 -> notExit = false;
                    default -> writeString("Operation not found");
                }
            } catch (UserException | AddRoleException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menuCreate() {
        boolean notExit = true;
        while (notExit) {
            showSaveUserMenu();
            try {
                switch (readInt()) {
                    case 1 -> userAction.save();
                    case 0 -> notExit = false;
                    default -> writeString("Operation not found");
                }
            } catch (AddRoleException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void showUserMenu() {
        writeString("\n" + "!!!!! USER MENU!!!!!" + "\n");
        writeString("0  - Exit");
        writeString("1  - GET USER MENU");
        writeString("2  - REMOVE USER MENU");
        writeString("3  - UPDATE USER MENU");
        writeString("4  - SAVE USER MENU" + "\n");

    }

    private void showGetUserMenu() {
        writeString("\n" + "!!!!!GET USER MENU!!!!!" + "\n");
        writeString("0  - Back");
        writeString("1  - get all user");
        writeString("2  - get user by id");
        writeString("3  - get user by firstname");
        writeString("4  - get user by lastname" + "\n");

    }

    private void showRemoveUserMenu() {
        writeString("\n" + "!!!!!GET USER MENU!!!!!" + "\n");
        writeString("0  - Back");
        writeString("1  - remove user by Id" + "\n");

    }

    private void showUpdateUserMenu() {
        writeString("\n" + "!!!!!UPDATE USER MENU!!!!!" + "\n");
        writeString("0  - Back");
        writeString("1  - update user email by id ");
        writeString("2  - update user firstname by id");
        writeString("3  - update user lastname by id");
        writeString("4  - update user role by id");
        writeString("5  - update user phones by id");
        writeString("6  - update user mobile number by id ");
        writeString("7  - update user home number by id " + "\n");
    }

    private void showSaveUserMenu() {
        writeString("\n" + "!!!!!Save USER MENU!!!!!" + "\n");
        writeString("0  - Back");
        writeString("1  - save user" + "\n");
    }
}