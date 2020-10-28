package lab13;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    /*
    2 задание - сделать проверку на формат электронной почты
    использовать библиотеку hashmap, map;
     */
    public ArrayList<String> catalogue = new ArrayList<>();

    TodoList() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String temp[];
        temp = str.split(" ");

        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "ADD":
                    System.out.println(i);
                    if(temp[i+2].charAt(0) >= '0' && temp[i+2].charAt(0) <= '9') {
                        Add(temp[i++], Integer.parseInt(temp[i += 2]));
                        i += 3;
                    }
                    else {
                        Add(temp[i++]);
                        i+=2;
                    }
                    System.out.println(i);
                    break;
                case "LIST":
                    List();
                    break;
                case "EDIT":
                    Edit(temp[i++] ,Integer.parseInt(temp[i+=2]));
                    i+=3;
                    break;
                case "DELETE":
                    Delete(Integer.parseInt(temp[i++]));
                    i+=2;
                    break;
                default:
                    System.err.println("Неверный формат ввода");
            }
        }
    }

    void List() {
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println("дело номер " + i + ":" + catalogue.get(i));
        }
    }

    String Delete(int num){
        catalogue.remove(num);
        return "Дело номер " + num + "удалено.";
    }

    String Add(String text, int position){
        catalogue.add(position, text);
        return "Дебавлено на позицию: " + position;
    }
    String Add(String text){
        catalogue.add(text);
        return "Дебавлено в конец";
    }
    String Edit(String text, int num){
        catalogue.remove(num);
        catalogue.add(num, text);
        return "Дело номер: " + num + "заменено.";
    }
}