package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneService {
    boolean save(Telephone telephone);

    Telephone updatePhoneByHomeNumber(int id, String homeNumber) throws TelephoneException;
    Telephone updatePhoneByMobileNumber(int id, String mobileNumber) throws TelephoneException;


    void remove(int id) throws TelephoneException;
    void remove(String homeNumber);
    void remove(int id, String mobileNumber) throws TelephoneException;
    void remove(Telephone telephone) throws TelephoneException;

    Telephone getPhoneById(int id) throws TelephoneException;
    Telephone getPhoneByHomeNumber(String homeNumber);
    Telephone getPhoneMobileNumber(String mobileNumber);
    Telephone[] getAllPhones();
}
