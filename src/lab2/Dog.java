package lab2;

import java.util.Scanner;

public class Dog {

    private String name, colour;
    private int age;


    Dog(String name, String colour, int age){
        this.name = name;
        this.age = age;
        this.colour = colour;
    }


    void SetAge(int age){
        this.age = age;
    }
    int GetAge(){
        return age;
    }
    void SetName(String name){
        this.name = name;
    }
    String GetName(){
        return name;
    }

    int DogAgeToPerson(){
        return age*7;
    }

        @Override
        public String toString(){
            return "The dog`s name is: " + name +"\nIt`s age is: "+ age + "\nColour: " + colour + "\nFor people it`s: " + DogAgeToPerson();
    }
}


class PytomnicSobak{

    public static void main(String[] args) {
        int age, age1, size;
        String name, colour, name1, colour1;
        Scanner in = new Scanner(System.in);
        System.out.print("Write down amount of dogs: ");
        size = in.nextInt();
        System.out.println();
        in.skip(".*\n");                             //очистка буфера
        Dog[] dogs = new Dog[size];

        for(int i=0; i< dogs.length; i++){
            dogs[i] = new Dog(in.nextLine(), in.nextLine(), in.nextInt());
            in.skip(".*\n");
        }
        System.out.println();
        for(int i=0; i< dogs.length; i++){
            System.out.println(dogs[i].toString());
            System.out.println();
        }
    }
}