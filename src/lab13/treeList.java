package lab13;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class treeList {
    private TreeSet<String> mailList = new TreeSet<>();

    void checkMail(String str, Pattern pattern){
        boolean dot = false;
        boolean at = false;
        boolean id = true;
        Matcher matcher;


        for (int i = 0; i < str.length(); i++) {
            //System.out.println(str.charAt(i));
            if(!at && str.charAt(i) == '@'){
                at = true;
            }else if((str.charAt(i)<97 && str.charAt(i)>122) || (str.charAt(i)<65 && str.charAt(i)>90)){
                id = false;
            }
            else if( ((str.charAt(i) == '.' && i+1 >= str.length()) || (at && str.charAt(i) == '@') || (str.charAt(i) == '@' && str.charAt(i+1) == '.') || (str.charAt(i) == '.' && str.charAt(i+1) == '@'))) {
                id = false;
            }
            else if(!dot && at && str.charAt(i) == '.' ){
                dot = true;
            }
            else if (at  && dot && str.charAt(i) == '.') {
                id = false;
            }
        }
        matcher = pattern.matcher(str);
        boolean found = matcher.matches();
        if (found)
        {
            mailList.add(str);
            System.out.println("Добавлено");
        } else
            System.err.println("Неверный адрес");
    }
    void read(Pattern pattern){
        String str;
        Scanner in = new Scanner(System.in);
        boolean work = true;

        do{
            str = in.nextLine();
            String[] temp = str.split(" ");

        for(int i=0; i<temp.length; i++){
            switch (temp[i]) {
                case "ADD":
                    i++;
                    checkMail(temp[i], pattern);
                    break;
                case "LIST":
                    System.out.println();
                    for (String mail : mailList) {
                        System.out.println(mail);
                    }
                    break;
                case "-1":
                    work = false;
                    break;
                default:
                    System.err.println("Неверная команда");
                    break;
                }
            }
        } while(work);
    }

    public static void main(String[] args) {
        Pattern pattern;
        pattern = Pattern.compile("^([A-Za-z0-9]{1,}[\\\\.-]{0,1}[A-Za-z0-9]{1,})+@([A-Za-z0-9]{1,}[\\\\.-]{0,1}[A-Za-z0-9]{1,})+[\\\\.]{1}[a-z]{2,4}$");
       new treeList().read(pattern);
       //ADD ex@gmail.com ADD ex.@gmail.com ADD ex@gmail.c.om LIST
    }
}
