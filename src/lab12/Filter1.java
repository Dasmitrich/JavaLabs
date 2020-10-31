package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Filter1
{
    String line = "Вася заработал 56 рублей, Петя - 7563 рубля, а Маша - 300 рублей";
    boolean check = false;
    String a = "";
    String number = "";
    ArrayList<Human> human = new ArrayList<Human>();

    public void search()
    {
        for(int i = 0; i < line.length(); i++)
        {
            if(line.charAt(i) > 1039 && line.charAt(i) < 1072 || check)
            {
                check = true;
                a += line.charAt(i);

                if(line.charAt(i + 1) == ' ' && i < line.length() - 1)
                    check = false;
            }
            else if(line.charAt(i) > 47 && line.charAt(i) < 58)
            {
                number += line.charAt(i);
                if(line.charAt(i + 1) == ' ' && i < line.length() - 1)
                {
                    human.add(new Human(a,Integer.parseInt(number)));
                    a = "";
                    number = "";
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Filter1 firstNumber = new Filter1();
        firstNumber.search();
        int sum = firstNumber.human.get(0).salary + firstNumber.human.get(2).salary;
        System.out.println(sum + " = " + firstNumber.human.get(0).name + " + " + firstNumber.human.get(2).name);
    }
}

class Human
{
    String name;
    int salary;
    Human(String name, int salary)
    {
        this.name = name;
        this.salary = salary;
    }
}