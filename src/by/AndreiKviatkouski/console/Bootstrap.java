package by.AndreiKviatkouski.console;

import by.AndreiKviatkouski.console.util.Writer;
import by.AndreiKviatkouski.domain.Role;
import by.AndreiKviatkouski.domain.Telephone;
import by.AndreiKviatkouski.domain.User;
import by.AndreiKviatkouski.storage.UserStorageImpl;

public class Bootstrap {
    public static void main(String[] args) {

        new ConsoleApplication().run();
    }
}
