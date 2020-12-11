package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneStorage {

   Telephone update(long id,Telephone telephone);

    boolean contains(String mobileNumber);
    boolean containsHomeNumber(String homeNumber);

}
