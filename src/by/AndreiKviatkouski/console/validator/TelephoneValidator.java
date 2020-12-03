package by.AndreiKviatkouski.console.validator;

import java.util.regex.Pattern;

public class TelephoneValidator {
    public static boolean validTelephone(String telephone){
        String telephoneRegex = "^\\+?375[-\\(]?\\d{2}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$";

        Pattern pat = Pattern.compile(telephoneRegex);
        if (telephone == null)
            return false;
        return pat.matcher(telephone).matches();
    }
    public static boolean validHomeTelephone(String telephone){
        String telephoneRegex = "^\\+?8017[-]?\\d{3}-?\\d{2}-?\\d{2}$";

        Pattern pat = Pattern.compile(telephoneRegex);
        if (telephone == null)
            return false;
        return pat.matcher(telephone).matches();
    }
}
