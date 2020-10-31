package lab13;

import java.util.Scanner;
import java.util.TreeSet;

public class treeList {
    private TreeSet<String> mailList = new TreeSet<>();

    void checkMail(String str){
        boolean dot = false;
        boolean at = false;
        boolean id = true;

        for (int i = 0; i < str.length(); i++) {
            //System.out.println(str.charAt(i));
            if(!at && str.charAt(i) == '@'){
                at = true;
            }
            else if((at && str.charAt(i) == '@') || (str.charAt(i) == '@' && str.charAt(i+1) == '.') || (str.charAt(i) == '.' && str.charAt(i+1) == '@') || (str.charAt(i) == '.' && str.charAt(i+1) == '.')) {
                id = false;
            }
            else if(!dot && at && str.charAt(i) == '.' ){
                dot = true;
            }
            else if (at  && dot && str.charAt(i) == '.') {
                id = false;
            }
        }
        if(!dot || !at)
            id = false;

        if(id) {
            mailList.add(str);
            System.out.println("Добавлено");
        }
        else
            System.err.println("Неверный адрес");
    }
    void read(){
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        String[] temp = str.split(" ");

        for(int i=0; i<temp.length; i++){
            switch (temp[i]){
                case "ADD":
                    i++;
                    checkMail(temp[i]);
                    break;
                case "LIST":
                    System.out.println();
                    for(String mail: mailList){
                        System.out.println(mail);
                    }
                    break;
                default:
                    System.err.println("Неверная команда");
                    break;
            }
        }
    }

    public static void main(String[] args) {
       new treeList().read();
       //ADD ex@gmail.com ADD ex.@gmail.com ADD ex@gmail.c.om LIST
    }
}
