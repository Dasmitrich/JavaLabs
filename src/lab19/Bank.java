package lab19;

import java.util.*;

public class Bank extends Thread {
    public HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public Bank(){
        accounts.put("1243812", new Account(500000, "1243812"));
        accounts.put("1234233", new Account(1000, "1234233"));
        accounts.put("6782342", new Account(561321, "6782342"));
        accounts.put("4924574", new Account(900, "4924574"));
        accounts.put("4624962", new Account(1000000, "4624962"));
        accounts.put("9813122", new Account(900000, "9813122"));
        accounts.put("5541235", new Account(2431000, "5541235"));
        accounts.put("7816511", new Account(1, "7816511"));
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        synchronized (this) {
            if (!isFraud(fromAccountNum, toAccountNum, amount)) {
                System.out.println("Счета заблокированы: " + fromAccountNum + " , " + toAccountNum);
                this.accounts.get(fromAccountNum).blockUser();
                this.accounts.get(toAccountNum).blockUser();
            } else if (!this.accounts.get(fromAccountNum).isBlocked() && !this.accounts.get(toAccountNum).isBlocked()) {
                new Thread(() -> {
                    this.accounts.get(fromAccountNum).setMoney(-amount);
                }).start();
                new Thread(() -> {
                    this.accounts.get(toAccountNum).setMoney(amount);
                    System.out.println("Деньги успешно переведены!");
                }).start();
            }
        }
    }

    public void getBalance(String accountNum) {
        synchronized (this) {
            new Thread(() -> {
                System.out.println("Ваш остаток по счету: " + this.accounts.get(accountNum).getSum());
            }).start();
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Для одновременного выполнения доступно " + Runtime.getRuntime().availableProcessors() + " потоков");
        System.out.println("Введите желаемое количество потоков: ");
        int thrNum = sc.nextInt();

        ArrayList<String> bill = new ArrayList<>();
        ArrayList<String> sendTo = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        ArrayList<String> account = new ArrayList<>();
        sc.skip(".*\n");

        for (int i = 0; i < thrNum; i++) {

            System.out.println("Нажмите 1 - чтобы перевести деньги, 2 - чтобы узнать баланс");
            String str = new Scanner(System.in).nextLine();

            if (str.equals("1")) {
                System.out.println("Введите Ваш номер счета");
                bill.add(new Scanner(System.in).nextLine());
                System.out.println("Введите номер счета адресанта");
                sendTo.add(new Scanner(System.in).nextLine());
                System.out.println("Введите сумму");
                sum.add(new Scanner(System.in).nextInt());
            } else if (str.equals("2")) {
                System.out.println("Введите номер счета:");
                account.add(new Scanner(System.in).nextLine());
            }else{
                System.out.println("Неправильно введено число. Попробуйте еще раз");
                i--;
            }
        }

        for(int i=0; i < bill.size(); i++){

            if(!accounts.containsKey(bill.get(i)) || !accounts.containsKey(sendTo.get(i))) {
                System.out.println("Счет не найден!");
            } else if (accounts.get(bill.get(i)).getSum() < sum.get(i)) {
                System.out.println("Недостаточно денег на счету");
            } else {
                try {
                    transfer(bill.get(i), sendTo.get(i), sum.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for(int i=0; i<account.size(); i++){

            if(!accounts.containsKey(account.get(i))) {
                System.out.println("Счет не найден!");
            } else{
                getBalance(account.get(i));
            }
        }
    }

    public static void main(String[] args) {
        new Bank().run();
    }
}