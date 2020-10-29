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
    private int i=0;


    public void RunApp() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String temp[];
        temp = str.split(" ");

        for (i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "ADD":
                   // System.out.println("from add " + temp[i+1].charAt(0));
                    if(temp[i+1].charAt(0) >= '0' && temp[i+1].charAt(0) <='9' && i+1< temp.length) {
                        Add(temp, Integer.parseInt(temp[i+1]));
                    }
                    else {
                        Add(temp);
                    }
                    break;
                case "LIST":
                    System.out.println();
                    List();
                    break;
                case "EDIT":
                    Edit(temp ,Integer.parseInt(temp[i+1]));
                    break;
                case "DELETE":
                    Delete(Integer.parseInt(temp[i+1]));
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
        System.out.println("Дело номер: " + num + " - удалено");
        i++;
    }

    private String addCheck(String[] temp){
        String text = "";

        do{
            i++;
            //System.out.println(temp[i] + " added " + i);
            text += temp[i] + " ";
        } while ( i+1 < temp.length && !temp[i+1].equals("ADD") && !temp[i+1].equals("EDIT") && !temp[i+1].equals("DELETE") && !temp[i+1].equals("LIST"));
        return text;
    }

    void Add(String[] temp, int position){
        i++;

        String text = addCheck(temp);

        catalogue.add(position, text);
        System.out.println("Добавлено на позицию: " + position +  " - " + text);
    }
    void Add(String[] temp){

        String text = addCheck(temp);

        catalogue.add(text);
        System.out.println("Добавлено в конец: " + text);
    }

    void Edit(String[] temp, int num){

        i++;
        String text = addCheck(temp);

        catalogue.set(num, text);
        System.out.println("Дело номер: " + num + " - заменено");
    }

}