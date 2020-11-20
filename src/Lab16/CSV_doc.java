package Lab16;
import java.io.*;

public class CSV_doc {


        static public String NormFunc(String tmp){
            String norm="";
            for (int i = 0; i<tmp.length();i++){
                if (((int)tmp.charAt(i)>64 &&(int)tmp.charAt(i)<91)||((int)tmp.charAt(i)>96 &&(int)tmp.charAt(i)<123))
                {
                    norm += tmp.charAt(i);
                }
            }
            if (norm.contains("RUR"))
                norm = norm.substring(0,norm.indexOf("RUR"));
            if (norm.contains("EUR"))
                norm = norm.substring(0,norm.indexOf("EUR"));
            if (norm.contains("USD"))
                norm = norm.substring(0,norm.indexOf("USD"));


            return norm;
        }

        static public void Parse() throws FileNotFoundException {
            try {
                File table = new File(System.getProperty("user.dir") + "\\movementList.csv");
                FileInputStream inputStream = new FileInputStream(table);
                String parse="";

                while (true) {
                    int code = inputStream.read();

                    if (code < 0)
                        break;

                    char ch = (char) code;
                    parse += ch;
                }
                inputStream.close();
                String[] cells = parse.split(";");
                String[][] mas = new String[120][8];
                int k=0;

                for(int i =0; i< 120; i++){
                    for(int j = 0; j<8 ; j++){
                        if (k<cells.length)
                            mas[i][j] = cells[k];
                        k++;

                    }
                }
                double sum=0;
                for (int i = 1; i<120; i++){
                    sum += Double.valueOf(mas[i][7]);
                }
                System.out.println("Сумма расходов" + sum);
                sum = 0;
                for (int i = 1; i<120; i++){
                    sum += Double.valueOf(mas[i][6]);
                }
                System.out.println("Сумма доходов" + sum);
                System.out.println("Суммы расходов по организациям:");
                int check[]= new int[120];
                for (int i =0; i<120; i++){
                    check[i] = 0;
                }
                String tmp = "";
                double summ2=0;
                boolean checked=false;
                for(int i =1;i<120;i++){
                    summ2 = 0;
                    for(int j=1;j<120;j++){

                        if ( NormFunc(mas[i][5]).equals(NormFunc(mas[j][5]))){

                            if (!checked){

                                if( check[i]!=1)
                                {
                                    summ2+=Double.parseDouble(mas[i][7]);
                                }
                                check[i]=1;
                                checked = true;
                            }

                            if(check[j]!=1 )
                            {
                                summ2+=Double.parseDouble(mas[j][7]);
                            }
                            check[j]=1;
                            mas[j][7]="0";
                        }

                    }
                    checked = false;
                    mas[i][7] = "0";
                    if (summ2 != 0){
                        System.out.println(NormFunc(mas[i][5]) + " " + summ2);
                    }
                }


            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            Parse();

        }
}
