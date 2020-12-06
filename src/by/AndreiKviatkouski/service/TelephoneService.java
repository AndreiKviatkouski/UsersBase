package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneService {

    Telephone updateHomeNumberByUserId(long id, String homeNumber) throws TelephoneException;
    Telephone updateMobileNumberByUserId(long id, String mobileNumber) throws TelephoneException;

}
