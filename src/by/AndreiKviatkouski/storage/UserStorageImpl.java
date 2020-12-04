package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

import java.util.ArrayList;
import java.util.Arrays;


public class UserStorageImpl implements UserStorage {

    private static final User[] users = new User[50];
//    private static final ArrayList<User> users = new ArrayList<>();

    static {
        Telephone telephone1 = new Telephone("8017-100-00-01", "+375-00-100-00-01");
        Telephone telephone2 = new Telephone("8017-200-00-02", "+375-00-200-00-02");
        users[0] = new User(1, "Cho", "Li", "li@li.com", Role.ADMIN, telephone1);
        users[1] = new User(2, "Han", "Lun", "lun@li.com", Role.USER, telephone2);
    }



    @Override
    public boolean save(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public User updateUserByLastName(int id, String lastName) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setLastName(lastName);
                return value;
            }

        }
        return null;
    }

    @Override
    public User updateUserByFirstName(int id, String firstName) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setFirstName(firstName);
                return value;
            }

        }
        return null;
    }

    @Override
    public User updateUserByEmail(int id, String email) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setEmail(email);
                return value;
            }

        }
        return null;
    }

    @Override
    public User updateUserByTelephone(int id, Telephone telephone) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setTelephone(telephone);
                return value;
            }

        }
        return null;
    }

    @Override
    public User updateUserByRole(int id, Role role) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setRole(role);
                return value;
            }

        }
        return null;
    }


    @Override
    public void remove(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                for (int j = i; j < users.length + 1; j++) {
                    users[i] = users[j + 1];

                }
                break;
            }

        }

    }

    @Override
    public void remove(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                for (int j = i; j < users.length + 1; j++) {
                    users[i] = users[j + 1];
                }
                break;
            }

        }

    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }

        }
        return null;
    }

    @Override
    public User getUserByLastName(String lastName) {
        for (User user : users) {
            if (user.getLastName().equals(lastName)) {
                return user;

            }

        }
        return null;
    }

    @Override
    public User getUserByFirstName(String firstName) {
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User[] getAll() {
        int count = 0;
        for (User user : users) {
            if (user != null) {
                count++;
            }
        }
        return Arrays.copyOf(users, count);
    }

    @Override
    public boolean contains(User user) {
        for (User value : users) {
            if (value == null) break;
            if (value.equals(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        for (User user : users) {
            if (user == null) break;
            if (user.getId() == id) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String lastName) {
        for (User user : users) {
            if (user == null) break;
            if (user.getLastName().equals(lastName)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean contains(String firstName, String lastName) {
        for (User user : users) {
            if (user == null) break;
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
