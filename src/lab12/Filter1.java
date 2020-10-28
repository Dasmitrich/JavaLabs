package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Filter1 {
    String text = new String("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей");
    public static void main(String[] args) {
        Filter1 f = new Filter1();
        int V1 = f.text.indexOf(' ', 10);
        int V2 = f.text.indexOf(' ', f.text.indexOf(' ')+V1);
        int M1 = f.text.indexOf(' ', V2+35);
        int M2 = f.text.indexOf(' ', f.text.indexOf(' ')+M1);
        int sum = Integer.parseInt(f.text.substring(++V1, V2)) + Integer.parseInt(f.text.substring(++M1, M2));
        System.out.println("Sum: " + sum);
    }
}