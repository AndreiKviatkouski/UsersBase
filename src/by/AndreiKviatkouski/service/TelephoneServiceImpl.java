package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.storage.TelephoneStorageImpl;
import by.AndreiKviatkouski.storage.UserStorageImpl;

public class TelephoneServiceImpl implements TelephoneService {

    TelephoneStorageImpl telephoneStorage = new TelephoneStorageImpl();
    UserStorageImpl userStorage = new UserStorageImpl();

    @Override
    public Telephone updateHomeNumberByUserId(long id, String homeNumber) throws TelephoneException {
        if (!telephoneStorage.contains(homeNumber) && userStorage.contains(id)) {
            return telephoneStorage.updateHomeNumberByIdUser(id, homeNumber);
        }
        throw new TelephoneException("Phone exist: " + homeNumber + " Try again!");
    }

    @Override
    public Telephone updateMobileNumberByUserId(long id, String mobileNumber) throws TelephoneException {
        if (!telephoneStorage.contains(mobileNumber) && userStorage.contains(id)) {
           return telephoneStorage.updateMobileNumberByIdUser(id, mobileNumber);
        }
        throw new TelephoneException("Phone exist: " + mobileNumber + " Try again!");
    }
}
