package by.AndreiKviatkouski.console.action;

import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneAction {
    boolean save(Telephone telephone);

    void updatePhoneByHomeNumber();
    void  updatePhoneByMobileNumber();


    void removeById();
    void removeByHomeNumber();
    void removeByMobileNumber();
    void removeTelephone();

    void  getPhoneById() ;
    void  getPhoneByHomeNumber();
    void  getPhoneMobileNumber();
    void  getAllPhones();
}
