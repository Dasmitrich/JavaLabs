package lab14;

import java.util.ArrayList;
import java.util.Random;

public class wordGenerator {
    private char[] patternNumbers = {'A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'};
    private ArrayList<String> carNumbers = new ArrayList<>();

    char genWord(){
        return patternNumbers[new Random().nextInt(patternNumbers.length)];
    }

    String genNum(){
       int num = new Random().nextInt(9);
       return String.valueOf(num) + String.valueOf(num) + String.valueOf(num);
    }

    String genRegn(){
        int num = new Random().nextInt(199);
        return String.valueOf(num);
    }

    void combine(){
        System.out.println(genWord()+ " "+ genNum()+ " " + genWord() + " " + genWord() + " " + genRegn());

    }



    public static void main(String[] args) {
        new wordGenerator().combine();
    }
}