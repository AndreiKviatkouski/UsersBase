package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

public class TelephoneStorageImpl implements TelephoneStorage {

    UserStorageImpl userStorage = new UserStorageImpl();


    @Override
    public Telephone updateHomeNumberByIdUser(long id, String homeNumber) {
        for (User user :  userStorage.getAll()) {
            if (user.getId() == id) {
                user.getTelephone().setHomeNumber(homeNumber);
            }
        }
        return null;
    }

    @Override
    public Telephone updateMobileNumberByIdUser(long id, String mobileNumber) {
        for (User user :  userStorage.getAll()) {
            if (user.getId() == id) {
                user.getTelephone().setMobileNumber(mobileNumber);
            }
        }
        return null;
    }


    @Override
    public boolean contains(String mobileNumber) {
        for (User user : userStorage.getAll()) {
            if (user == null) break;
            if (user.getTelephone().getMobileNumber().equals(mobileNumber)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean containsHomeNumber(String homeNumber) {
        for (User user : userStorage.getAll()) {
            if (user == null) break;
            if (user.getTelephone().getHomeNumber().equals(homeNumber)) {
                return true;
            }

        }
        return false;
    }
}
