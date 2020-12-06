package by.AndreiKviatkouski.console.validator;

import java.util.regex.Pattern;

public class UserValidator {
    public static boolean validId(long id) {
        return id > 0;
    }

    public static boolean validName(String name) {
        if (name==null){
            return false;
        }
        return name.length() > 1 ;
    }

    public static boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
