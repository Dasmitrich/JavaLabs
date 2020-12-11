package lab19;

public class Account
{
    private long money;
    private String accNumber;
    private boolean isBlocked = false;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public synchronized void blockUser(){
        this.isBlocked = true;
    }

    String getAccNumber(){
        return accNumber;
    }

    void setMoney(long amount){
        money += amount;
    }

    public boolean isBlocked(){
        return isBlocked;
    }

    public long getSum(){
        return money;
    }
}
