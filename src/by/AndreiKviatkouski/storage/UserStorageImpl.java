package by.AndreiKviatkouski.storage;

import by.AndreiKviatkouski.console.exception.AddRoleException;
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

        User existedUser = getById(id);

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
            existedUser.getRoles().removeAll(existedUser.roles);
            for (Role role : user.getRoles()) {
                existedUser.addRole(role);
            }
        }

        if (user.getTelephone() != null) { 
            existedUser.setTelephone(user.getTelephone());
        }
        return existedUser;
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
    public List<User> getUserByParams(User userNew) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equals(userNew.getFirstName())) {
                userList.add(user);
            }
            if (user.getLastName().equals(userNew.getLastName())) {
                userList.add(user);
            }
        }
        return userList;
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
}

