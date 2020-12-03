package by.AndreiKviatkouski.console.validator;

import java.util.regex.Pattern;

public class UserValidator {
    public static boolean validId(int id) {
        return id > 0;
    }

    public static boolean validName(String name) {
        return name.length() > 0;
    }

    public static boolean validEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }







//    public static void main(String[] args)
//    {
//        String email = "qqqq@wwww.org";
//        if (validEmail(email))
//            System.out.print(true);
//        else
//            System.out.print(false);
//        String telephone = "+375-29-100-00-00";
//        if (validTelephone(telephone))
//            System.out.print(true);
//        else
//            System.out.print(false);
//    }
}
