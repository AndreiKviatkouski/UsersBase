package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.console.exception.AddRoleException;
import by.AndreiKviatkouski.console.exception.UserException;
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
        User user1 = new User(1, "Bob", "Li", "cho@li.com", telephone1);
        User user2 = new User(2, "Bob", "Beans", "bob@gmail.com", telephone2);
        User user3 = new User(3, "Ivan", "Li", "ivan@mail.ru", telephone3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        try {
            user1.addRole(new Role(Role.USER));
            user1.addRole(new Role(Role.ADMIN));
            user2.addRole(new Role(Role.CUSTOMER));
            user2.addRole(new Role(Role.PROVIDER));
            user3.addRole(new Role(Role.SUPER_ADMIN));
        } catch (AddRoleException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public User update(long id, User user) throws AddRoleException {
//        if (user.getId() == 0) {
//            throw new UserException();
//        }

        User existedUser = getById(user.getId());

        if (user.getFirstName() != null) {
            existedUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            existedUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            existedUser.setEmail(user.getEmail());
        }
        if (user.getRoles() != null) {
            existedUser.addRole((Role) user.getRoles());
        }
        if (user.getTelephone() != null) {
            existedUser.setTelephone(user.getTelephone());
        }
        save(existedUser);
        return user;
    }


    @Override
    public void remove(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(users.get(i));
            }
        }
    }

//    public List<User> getByParams(Params...) {
//        "select * from user where firstname= ''' and lastname .....    "
//    }

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
    public List<User> getUserByLastName(String lastName) {
        List<User> lastNameList = new ArrayList<>();
        for (User user : users) {
            if (user.getLastName().equals(lastName)) {
                lastNameList.add(user);
            }
        }
        return lastNameList;
    }


    @Override
    public List<User> getUserByFirstName(String firstName) {
        List<User> firstNameList = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                firstNameList.add(user);
            }
        }
        return firstNameList;
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
    public boolean containsLastName(String lastName) {
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
            if (user.getEmail().equals(email)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        UserStorageImpl userStorage = new UserStorageImpl();
        System.out.println(userStorage.containsLastName("Beans"));
        System.out.println(userStorage.getUserByLastName("Li"));

    }
}

