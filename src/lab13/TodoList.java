package lab13;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    /*
    2 задание - сделать проверку на формат электронной почты
    использовать библиотеку hashmap, map;
     */
    public ArrayList<String> catalogue = new ArrayList<>();
    public static int i = 0;

    public void RunApp() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String temp[];
        temp = str.split(" ");


        System.out.println(temp.length);

        for (i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "ADD":
                    if(temp[i+1].charAt(0) >= '0' && temp[i+1].charAt(0) <= '9') {
                        Add(temp, Integer.parseInt(temp[i+1]));
                    }
                    else {
                        Add(temp);
                    }
                    break;
                case "LIST":
                    List();
                    break;
                case "EDIT":
                    Edit(temp ,Integer.parseInt(temp[i+1]), i);
                    break;
                case "DELETE":
                    i++;
                    Delete(Integer.parseInt(temp[i]));
                    i++;
                    break;
                default:
                    System.err.println("Неверный формат ввода");
            }
        }
    }

    void List() {
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println("дело номер " + i + ": " + catalogue.get(i));
        }
    }

    void Delete(int num){
        catalogue.remove(num);
        System.out.println("Дело номер " + num + "удалено.");
    }

    void Add(String[] temp, int position){
        String text = null;

            i+=2;
            if(temp[i].equals("ADD") && temp[i].equals("EDIT") && temp[i].equals("DELETE") && temp[i].equals("LIST")){
            text = temp[i];
            i++;
            }
            catalogue.add(position, text);

        System.out.println("Добавлено на позицию: " + position);
    }
    void Add(String[] temp){
        String text = new String();

        while(!temp[i].equals("ADD") && !temp[i].equals("EDIT") && !temp[i].equals("DELETE") && !temp[i].equals("LIST")){
            System.out.println(temp[i] + " added");
            text += temp[i];
            System.out.println(text);
            if(i!=temp.length)
                i++;
        }

        catalogue.add(text);
        System.out.println("Добавлено в конец: " + i);
    }

    void Edit(String[] temp, int num, int i){
        catalogue.remove(num);
        System.out.println("Дело номер: " + num + "заменено.");
        Add(temp, num);
    }
}