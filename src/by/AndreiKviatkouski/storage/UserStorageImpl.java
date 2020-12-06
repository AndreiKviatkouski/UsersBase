package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;

import java.util.ArrayList;
import java.util.List;


public class UserStorageImpl implements UserStorage {

    private static final List<User> users = new ArrayList<>();

    static {
        Telephone telephone1 = new Telephone("8017-100-00-00", "+375-29-100-00-00");
        Telephone telephone2 = new Telephone("8017-200-00-00", "+375-29-200-00-00");
        Telephone telephone3 = new Telephone("8017-300-00-00", "+375-29-300-00-00");
        User user1 = new User(1, "Cho", "Li", "cho@li.com", Role.ADMIN, telephone1);
        User user2 = new User(2, "Bob", "Jenson", "bob@gmail.com", Role.USER, telephone2);
        User user3 = new User(3, "Ivan", "Petrov", "ivan@mail.ru", Role.MODERATOR, telephone3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }


    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public void updateUserByLastName(long id, String lastName) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setLastName(lastName);
                return;
            }

        }
    }

    @Override
    public void updateUserByFirstName(long id, String firstName) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setFirstName(firstName);
                return;
            }

        }
    }

    @Override
    public void updateUserByEmail(long id, String email) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setEmail(email);
                return;
            }

        }
    }

    @Override
    public void updateUserByTelephone(long id, Telephone telephone) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setTelephone(telephone);
                return;
            }

        }
    }

    @Override
    public void updateUserByRole(long id, Role role) {
        for (User value : users) {
            if (value.getId() == id) {
                value.setRole(role);
                return;
            }

        }
    }


    @Override
    public void remove(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(users.get(i));
            }
        }
    }


    @Override
    public void remove(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(users.get(i));
            }
        }
    }


    @Override
    public User getById(long id) {
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
    public List<User> getAll() {
        return users;
    }

    @Override
    public boolean contains(User user) {
        return users.contains(user);
    }

    @Override
    public boolean contains(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String lastName) {
        for (User user : users) {
            if (user.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsFirstName(String firstName) {
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return true;
            }

        }
        return false;
    }
}

