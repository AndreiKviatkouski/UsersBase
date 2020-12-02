package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

public interface TelephoneStorage {
    boolean save(Telephone telephone);

    Telephone updatePhoneByHomeNumber(int id, String homeNumber);
    Telephone updatePhoneByMobileNumber(int id, String mobileNumber);


    void remove(int id);
    void remove(String homeNumber);
    void remove(int id, String mobileNumber);
    void remove(Telephone telephone);

    Telephone getPhoneById(int id);
    Telephone getPhoneByHomeNumber(String homeNumber);
    Telephone getPhoneMobileNumber(String mobileNumber);
    Telephone[] getAllPhones();

    boolean contains(Telephone telephone);
    boolean contains(int id);
    boolean contains(String mobileNumber);
    boolean contains(int id, String homeNumber);
}
