package lab14;

import java.util.*;

public class WordGenerator {
    //ПРОГРАММА СЧИТЫВАЕТ ТОЛЬКО БУКВЫ НА АНГЛИЙСКОЙ РАСКЛАДКЕ
    private String[] patternWords = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
    private String[] patternNumbers = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
    private ArrayList<String> carNumbers = new ArrayList<>();

    void combine(){
        for(int i=0; i<12; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<12; k++){
                    for(int l=0; l<12; l++){
                        for (int m=1; m < 200; m++){
                            carNumbers.add(patternWords[i] + patternNumbers[j] + patternWords[k] + patternWords[l] + String.valueOf(m));
                        }
                    }
                }
            }
        }

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