package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.console.exception.UserException;

public interface TelephoneAction {

    void updatePhoneHomeNumberById() throws UserException, AddRoleException, TelephoneException;
    void  updatePhoneMobileNumberById() throws UserException, TelephoneException;
}
