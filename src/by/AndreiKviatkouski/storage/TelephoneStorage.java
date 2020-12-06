package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Telephone;

public interface TelephoneStorage {

   Telephone updateHomeNumberByIdUser(long id, String homeNumber);
   Telephone updateMobileNumberByIdUser(long id, String mobileNumber);

    boolean contains(String mobileNumber);
    boolean containsHomeNumber(String homeNumber);

}
