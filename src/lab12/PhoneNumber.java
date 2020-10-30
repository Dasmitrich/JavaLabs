package lab12;

import java.util.Scanner;

public class PhoneNumber {
    public String PhoneNumberEdit(String str) {
        /*String str;
        Scanner in = new Scanner(System.in);

        str = in.nextLine();*/
        String number = new String();

        int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '-' || str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == ' ') && cnt < 12) {
                    if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        number += String.valueOf(str.charAt(i));
                        cnt++;
                    }
                } else {
                    return ("Неверный формат номера");
                }
            }
        if(number.length() == 10 && number.charAt(0) == '9')
            return ("+7 (" + number.substring(0,3) + ") " + number.substring(3,6) + "-" + number.substring(6,8) + "-" + number.substring(8,10));
        else if(number.length() == 11 && number.charAt(0) == '8' || number.charAt(0) == '7')
            return ("+7 (" + number.substring(1,4) + ") " + number.substring(4,7) + "-" + number.substring(7,9) + "-" + number.substring(9,11));
        else
            return ("Неверный формат номера");
    }

    public static void main(String[] args) {
        new PhoneNumber().PhoneNumberEdit(null);
    }
}