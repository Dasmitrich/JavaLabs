package lab12;

import java.util.Scanner;

public class FilterSurname {

    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        String temp[];
        temp = str.split(" ");
        String slovo[] = {"Фамилия: ", "Имя: ", "Отчество: "};

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) < 'а' && str.charAt(i) > 'я' || str.charAt(i) < 'А' && str.charAt(i) > 'Я' || temp.length > 3 || temp.length < 2) {
                System.err.println("Введенная строка не является ФИО");
                return;
            }
        }

        for(int i=0; i < temp.length; i++){
            System.out.println(slovo[i] + temp[i] );
        }
    }
}