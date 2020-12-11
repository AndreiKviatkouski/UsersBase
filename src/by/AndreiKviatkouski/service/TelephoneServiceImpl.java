package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.storage.TelephoneStorageImpl;
import by.AndreiKviatkouski.storage.UserStorageImpl;

public class TelephoneServiceImpl implements TelephoneService {

    TelephoneStorageImpl telephoneStorage = new TelephoneStorageImpl();
    UserStorageImpl userStorage = new UserStorageImpl();

    @Override
    public Telephone update(long id, Telephone telephone) throws TelephoneException {
        if (userStorage.contains(id)) {
          return telephoneStorage.update(id, telephone);

        }
        throw new TelephoneException("Phone exist, try again!");
    }
}
