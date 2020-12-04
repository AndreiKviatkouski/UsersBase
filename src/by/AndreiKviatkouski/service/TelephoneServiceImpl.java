package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.console.exception.TelephoneException;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.storage.TelephoneStorageImpl;

public class TelephoneServiceImpl implements TelephoneService {

    TelephoneStorageImpl telephoneStorage = new TelephoneStorageImpl();
    @Override

    public boolean save(Telephone telephone) {
        if (telephoneStorage.contains(telephone)) {
            return false;
        }
        telephoneStorage.save(telephone);
        return true;
    }


    @Override
    public Telephone updatePhoneByHomeNumber(int id,String homeNumber) throws TelephoneException {
        if (telephoneStorage.contains(id, homeNumber)) {
            return telephoneStorage.updatePhoneByHomeNumber(id,homeNumber);
        }
        throw new TelephoneException("Could not find telephone with ID: " + id);
    }

    @Override
    public Telephone updatePhoneByMobileNumber(int id, String mobileNumber) throws TelephoneException {
        if (telephoneStorage.contains(id, mobileNumber)) {
            return telephoneStorage.updatePhoneByHomeNumber(id,mobileNumber);
        }
        throw new TelephoneException("Could not find telephone with ID: " + id);
    }

    @Override
    public void remove(int id) throws TelephoneException {
        if (telephoneStorage.contains(id)) {
            telephoneStorage.remove(id);
        }
        throw new TelephoneException("Could not find telephone with ID: " + id);
    }


    @Override
    public void remove(String homeNumber) {
        if (telephoneStorage.contains(homeNumber)){
            telephoneStorage.remove(homeNumber);
        }
    }


    @Override
    public void remove(int id, String mobileNumber) throws TelephoneException {
        if (telephoneStorage.contains(id,mobileNumber)) {
            telephoneStorage.remove(id,mobileNumber);
        }
        throw new TelephoneException("Could not find telephone with ID: " + id);
    }


    @Override
    public void remove(Telephone telephone) throws TelephoneException {
        if (telephoneStorage.contains(telephone)) {
            telephoneStorage.remove(telephone);
        }
        throw new TelephoneException("Could not find telephone: " + telephone);
    }


    @Override
    public Telephone getPhoneById(int id) throws TelephoneException {
        if (telephoneStorage.contains(id)) {
            return telephoneStorage.getPhoneById(id);
        }
        throw new TelephoneException("Could not find telephone with ID: " + id);
    }

    @Override
    public Telephone getPhoneByHomeNumber(String homeNumber) {
        if (telephoneStorage.contains(homeNumber)) {
            return telephoneStorage.getPhoneByHomeNumber(homeNumber);
        }
        return null;
    }

    @Override
    public Telephone getPhoneMobileNumber(String mobileNumber) {
        if (telephoneStorage.contains(mobileNumber)) {
            return telephoneStorage.getPhoneMobileNumber(mobileNumber);
        }
        return null;
    }

    @Override
    public Telephone[] getAllPhones() {
        return telephoneStorage.getAllPhones();
    }
}
