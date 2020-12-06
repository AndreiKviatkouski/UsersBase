package by.AndreiKviatkouski.console.util;

import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                int num = Integer.parseInt(readWithInvite("Please enter the number: " + "\n"));
                if (num < 0) throw new NumberFormatException();
                return num;
            } catch (NumberFormatException e) {
                Writer.writeString("Number incorrect! Try again!"+ "\n");
            }
        }

    }

    public static String readLine() {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            Writer.writeString("Was entered empty string,");
            return null;
        }
        return line;
    }


    public static String readWithInvite(String invite) {
        Writer.writeString(invite);
        return readLine();
    }

    public static long readId() {
        while (true) {
            try {
                long id = Long.parseLong(readWithInvite("Input Id:"));
                if (id < 0) throw new NumberFormatException();
                return id;
            } catch (NumberFormatException e) {
                Writer.writeString("Id incorrect! Try again!"+"\n");
            }
        }
    }
}

