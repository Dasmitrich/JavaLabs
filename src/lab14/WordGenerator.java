package lab14;

import java.util.*;

public class WordGenerator {
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
        for(int i=0; i<20000; i++){
            String temp = genWord() + genNum() + genWord() + genWord() + genRegn();
            if(!carNumbers.contains(temp))
            carNumbers.add(temp);
            else
                i--;
        }
        carNumbers.add("A222BH113");

        System.out.println("Enter your number: ");
        String temp = new Scanner(System.in).nextLine();
        HashSet<String> setCars = new HashSet(carNumbers);
        TreeSet<String> treeCars = new TreeSet(carNumbers);

        long time = System.nanoTime();
        if(carNumbers.contains(temp)) {
            time = System.nanoTime() - time;
            for(int i=0; i<carNumbers.size(); i++) {
                if(carNumbers.get(i).equals(temp))
                System.out.println("Поиск перебором: найдено на позиции " + i + " за " + time + " нс");
            }
        }
        int n = -1;
        Collections.sort(carNumbers);
        time = System.nanoTime();
        n = Collections.binarySearch(carNumbers, temp);
        time = System.nanoTime() - time;
        if(n>-1) {
                    System.out.println("Поиск бинарный: найдено на позиции " + n + " за " + time + " нс");
        }
        time = System.nanoTime();
        if(setCars.contains(temp)) {
            time = System.nanoTime() - time;
            for(int i=0; i<carNumbers.size(); i++) {
                if(carNumbers.get(i).equals(temp))
                    System.out.println("Поиск в HashSet: найдено на позиции " + i + " за " + time + " нс");
            }
        }
        time = System.nanoTime();
        if(treeCars.contains(temp)) {
            time = System.nanoTime() - time;
            for(int i=0; i<carNumbers.size(); i++) {
                if(carNumbers.get(i).equals(temp))
                    System.out.println("Поиск в TreeSet: найдено на позиции " + i + " за " + time + " нс");
            }
        }
    }



    public static void main(String[] args) {
        new WordGenerator().combine();
    }
}