package by.AndreiKviatkouski.storage;
import by.AndreiKviatkouski.domain.Telephone;

import java.util.Arrays;


public class TelephoneStorageImpl implements TelephoneStorage {
    private static final Telephone[] telephones = new Telephone[50];

    static {
        telephones[0] = new Telephone(1, "11", "22");
        telephones[1] = new Telephone(2, "11", "22");
    }

    @Override
    public boolean save(Telephone telephone) {
        for (int i = 0; i < telephones.length; i++) {
            if (telephones[i] == null) {
                telephones[i] = telephone;
                return true;
            }
        }
        return false;
    }

    @Override
    public Telephone updatePhoneByHomeNumber(int id, String homeNumber) {
        for (Telephone telephone : telephones) {
            if (telephone.getId() == id) {
                telephone.setHomeNumber(homeNumber);
                return telephone;
            }

        }
        return null;
    }

    @Override
    public Telephone updatePhoneByMobileNumber(int id, String mobileNumber) {
        for (Telephone telephone : telephones) {
            if (telephone.getId() == id) {
                telephone.setMobileNumber(mobileNumber);
                return telephone;
            }

        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < telephones.length; i++) {
            if (telephones[i].getId() == id) {
                for (int j = i; j < telephones.length + 1; j++) {
                    telephones[i] = telephones[j + 1];

                }
                break;
            }

        }

    }


    @Override
    public void remove(String homeNumber) {
        for (int i = 0; i < telephones.length; i++) {
            if (telephones[i].getHomeNumber().equals(homeNumber)) {
                for (int j = i; j < telephones.length + 1; j++) {
                    telephones[i] = telephones[j + 1];

                }
                break;
            }

        }

    }

    @Override
    public void remove(int id, String mobileNumber) {
        for (int i = 0; i < telephones.length; i++) {
            if (telephones[i].getId() == id || telephones[i].getMobileNumber().equals(mobileNumber)) {
                for (int j = i; j < telephones.length + 1; j++) {
                    telephones[i] = telephones[j + 1];
                }
                break;
            }

        }
    }


    @Override
    public void remove(Telephone telephone) {
        for (int i = 0; i < telephones.length; i++) {
            if (telephones[i].equals(telephone)) {
                for (int j = i; j < telephones.length + 1; j++) {
                    telephones[i] = telephones[j + 1];
                }
                break;
            }

        }
    }

    @Override
    public Telephone getPhoneById(int id) {
        for (Telephone telephone : telephones) {
            if (telephone.getId() == id) {
                return telephone;
            }

        }
        return null;
    }

    @Override
    public Telephone getPhoneByHomeNumber(String homeNumber) {
        for (Telephone telephone : telephones) {
            if (telephone.getHomeNumber().equals(homeNumber)) {
                return telephone;
            }

        }
        return null;
    }

    @Override
    public Telephone getPhoneMobileNumber(String mobileNumber) {
        for (Telephone telephone : telephones) {
            if (telephone.getMobileNumber().equals(mobileNumber)) {
                return telephone;
            }

        }
        return null;
    }

    @Override
    public Telephone[] getAllPhones() {
        int count = 0;
        for (Telephone telephone : telephones) {
            if (telephone != null) {
                count++;
            }
        }
        return Arrays.copyOf(telephones, count);
    }

    @Override
    public boolean contains(Telephone telephone) {
            for (Telephone value : telephones) {
                if (value == null) break;
                if (value.equals(telephone)) {
                    return true;
                }
            }
            return false;
        }

    @Override
    public boolean contains(int id) {
        for (Telephone value : telephones) {
            if (value == null) break;
            if (value.getId() == id) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String mobileNumber) {
        for (Telephone value : telephones) {
            if (value == null) break;
            if (value.getMobileNumber().equals(mobileNumber)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(int id, String homeNumber) {
        for (Telephone value : telephones) {
            if (value == null) break;
            if (value.getHomeNumber().equals(homeNumber)|| value.getId()==id) {
                return true;
            }

        }
        return false;
    }
}
