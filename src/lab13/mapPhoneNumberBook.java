package lab13;

import java.util.HashMap;
import java.util.Scanner;

public class mapPhoneNumberBook {
    private HashMap<Integer, String> phoneNumbersStore = new HashMap<>();


    void read(){
        String str = "";

        while (!str.equals("-1")) {
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            if(str.charAt(0)>='0' && str.charAt(0)<='9'){

            }
            else if(str.charAt(0)>='а' && str.charAt(0)<='я' || str.charAt(0)>='А' && str.charAt(0)<='Я'){

            }
        }
    }
}
//В РАЗРАБОТКЕ