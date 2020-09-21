package lab1;

import java.util.Random;
import java.util.Scanner;


public class main {

/*
    public static void main(String[] args) {
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = new Random().nextInt(100);
            System.out.println(num[i]);
        }

        System.out.println("\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(num[i]);
        }

    }
}*/

    //2 WORK

    static int randomdo(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int min = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            num[i] = randomdo(min, max);
            System.out.println(num[i]);
        }

        System.out.println("\n\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(num[i]);
        }
    }
}


        //3 WORK

   /* int fact(int n, int i) {
        return n*i;
    }

/*class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int counter = 1;
        main m = new main();
        int num1 = num;
        for (int i = 0; i < num; i++) {
            System.out.println(m.fact(num, i));
            num1 = m.fact(num, i);
        }
    }
}

 */
