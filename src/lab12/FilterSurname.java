package lab12;

import java.util.Scanner;

public class FilterSurname {

     public String StartFilter(String str) {
        /*String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();*/

        String result = "";
        String temp[];
        temp = str.split(" ");
        //String slovo[] = {"Фамилия: ", "Имя: ", "Отчество: "};

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) < 'а' && str.charAt(i) > 'я' || str.charAt(i) < 'А' && str.charAt(i) > 'Я' || temp.length > 3 || temp.length < 2) {
                result = "Введенная строка не является ФИО";
            }
        }
        if(!result.equals("Введенная строка не является ФИО"))
            result = str;

        return result;
    }
}