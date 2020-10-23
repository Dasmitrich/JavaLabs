package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Filter1 {
    String text = new String("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей");
    public static void main(String[] args) {
        Filter1 f = new Filter1();
        System.out.println("Patya: " + Integer.parseInt(f.text.substring(35,39)) + "\nMasha: " + Integer.parseInt(f.text.substring(56,61)));
    }
}