package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

public class TelephoneStorageImpl implements TelephoneStorage {

    UserStorageImpl userStorage = new UserStorageImpl();

    @Override
    public Telephone update(long id, Telephone telephone) {
        User existedUser = userStorage.getById(id);

        if (telephone.getMobileNumber() != null) {
            existedUser.getTelephone().setMobileNumber(telephone.getMobileNumber());
        }
        if (telephone.getHomeNumber() != null) {
            existedUser.getTelephone().setHomeNumber(telephone.getHomeNumber());
        }
        return telephone;
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
