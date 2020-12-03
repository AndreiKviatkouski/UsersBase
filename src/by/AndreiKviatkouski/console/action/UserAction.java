package by.AndreiKviatkouski.console.action;

public interface UserAction {
    void save();

    void updateUserByLastName();
    void updateUserByFirstName();
    void updateUserByEmail();
    void updateUserByTelephone();
    void updateUserByRole();


    void removeById();
    void removeUser();
    void getById();
    void getUserByLastName();
    void getUserByFirstName();
    void getAll();
}
