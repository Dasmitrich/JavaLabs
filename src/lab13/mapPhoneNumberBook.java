package lab13;

import lab12.FilterSurname;
import lab12.PhoneNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mapPhoneNumberBook {

    private HashMap<String, String> phoneNumbersStore = new HashMap<>();

    mapPhoneNumberBook(){
        this.phoneNumbersStore.put("+7 (495) 210-49-57", "Леопольдова Зинаида Петровна");
        this.phoneNumbersStore.put("+7 (977) 590-27-54", "Борисенко Альберт Вигенович");
        this.phoneNumbersStore.put("+7 (155) 233-90-09", "Дементьев Неси Свиней");
    }

    String getUser(String number){
        return phoneNumbersStore.get(number);
    }

    String addName(String number){
        String result = "";
        System.out.println("Введите имя нового контакта");

        String name = new Scanner(System.in).nextLine();
        result = new FilterSurname().StartFilter(name);

        if (!result.equals("Введенная строка не является ФИО")) {
            phoneNumbersStore.put(number, result);
            result = "Контакт добавлен";
        }
        return result;
    }

    String addNumber(String name){
        String result = "";
        System.out.println("Введите номер нового контакта");

        String number = new Scanner(System.in).nextLine();
        result = new PhoneNumber().PhoneNumberEdit(number);

        if (!result.equals("Неверный формат номера")) {
            phoneNumbersStore.put(result, name);
            result = "Контакт добавлен";
        }
        return result;
    }

    void userCheckName(String name) {
        boolean found = false;
        for (Map.Entry<String, String> entry : phoneNumbersStore.entrySet()) {
            if (entry.getValue().equals(name)) {
                found = true;
                System.out.println(entry.getKey());
            }
        }
        if(!found)
            System.out.println(addNumber(name));
    }

    void userCheckNumber(String number){
        String exists;
        exists = (phoneNumbersStore.containsKey(number))? getUser(number) : addName(number);

        System.out.println(exists);
    }
    void List(){
        for(Map.Entry<String, String> entry: phoneNumbersStore.entrySet()){
            System.out.println(entry.getValue() + "\n" + entry.getKey() + "\n");
        }
    }

    void runApp(){
        String str = "";
        String number;
        String name;

        while (!str.equals("-1")) {
            str = new Scanner(System.in).nextLine();

            if(str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) <= '+'){
                number = new PhoneNumber().PhoneNumberEdit(str);

                if(number.equals("Неверный формат номера")) {
                    System.err.println(number);
                    return;
                } else {
                    userCheckNumber(number);
                }

            } else if(str.charAt(0)>='а' && str.charAt(0)<='я' || str.charAt(0)>='А' && str.charAt(0)<='Я'){
                name = new FilterSurname().StartFilter(str);

                if(name.equals("Введенная строка не является ФИО")) {
                    System.err.println(name);
                    return;
                } else {
                    userCheckName(name);
                }

            } else if(str.equals("LIST")){
                List();
            }
        }
    }

    public static void main(String[] args) {
        mapPhoneNumberBook book = new mapPhoneNumberBook();
        book.runApp();
    }
}