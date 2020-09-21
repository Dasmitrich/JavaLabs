package lab1;

public class firstex {
    public static void main(String[] args) {
        int res=0;
        int[] ar = {1, 55, 90, 65, 31, 67};
        for(int i =0; i<6; i++){
            res += ar[i];
        }
        System.out.println(res);

        int i=0;
        res=0;
        System.out.println("\n\n");
        while (i<6){
            res+=ar[i];
            i++;
        }
        System.out.println(res);
        System.out.println("\n\n");
        res=0;
        i=0;
        do{
            res+=ar[i];
            i++;
        } while(i<6);
        System.out.println(res);

    }
}
