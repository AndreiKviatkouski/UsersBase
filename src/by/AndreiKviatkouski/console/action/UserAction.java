package by.AndreiKviatkouski.console.action;

public interface UserAction {
    void save();

    void updateUserLastNameById();
    void updateUserFirstNameById();
    void updateUserEmailById();
    void updateUserTelephonesById();
    void updateUserRoleById();


    void removeById();
    void removeUser();
    void getById();
    void getUserByLastName();
    void getUserByFirstName();
    void getAll();
}
