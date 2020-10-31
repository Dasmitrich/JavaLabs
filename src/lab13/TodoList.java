package lab13;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class TodoList {

    public static void main(String[] args) {
        /*
        ПРИМЕР ВВОДА КОМАНД:
        ADD 0 work to do ADD 1 buy something ADD 2 only fun ADD a bit more work to do ADD 3 the end DELETE 0 EDIT 1 get from restaurant LIST
        ADD more spicy food ADD snacks ADD plasmaTV ADD 2 toys EDIT 2 I wanted to say pizza
        ADD more spicy food ADD snacks ADD plasmaTV ADD 2 toys EDIT 2 I wanted to say pizza ADD something sweet DELETE 0 LIST
         */
        new TodoList().RunApp();
    }

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
            }
        }

    }

    void List() {
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println("дело номер " + i + ": " + catalogue.get(i));
        }
    }

    void Delete(int num){
        if(num < catalogue.size()) {
            catalogue.remove(num);
            System.out.println("Дело номер: " + num + " - удалено");
            i++;
        } else {
            System.out.println("Дело не найдено!");
            i++;
        }
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
        if(position < catalogue.size()) {
            i++;

            String text = addCheck(temp);

            catalogue.add(position, text);
            System.out.println("Добавлено на позицию: " + position + " - " + text);
        } else {
            System.out.println("Список составляет меньшую длину!");
            Add(temp);
        }
    }
    void Add(String[] temp){

        String text = addCheck(temp);

        catalogue.add(text);
        System.out.println("Добавлено в конец: " + text);
    }

    void Edit(String[] temp, int num){
        if(num < catalogue.size()) {
            i++;
            String text = addCheck(temp);

            catalogue.set(num, text);
            System.out.println("Дело номер: " + num + " - заменено");
        } else {
            i++;
            System.out.println("Данная позиция не найдена!");
        }
    }

}