/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart.services.system;

/**
 *
 * @author Kenzy Hassanen
 */
public class DigitalWallet {
   private String walletId;
   private String ownerName;
   private double balance;
   private int transactionCount;

    public DigitalWallet(String walletId, String ownerName, double balance) {
        this.walletId = walletId;
        this.ownerName = ownerName;
        this.transactionCount=0;
        if(balance<0)
            this.balance=0;
        else
             this.balance = balance;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setOwnerName(String ownerName) {
        if(ownerName.equals(""))
        {
            System.out.println("Error! invalid owner name");
        }
        else
        this.ownerName = ownerName;

    }
    
    public boolean deposit(double amount)
    {
        if(amount>0)
        {
            this.balance += amount;
            this.transactionCount ++;
            return true;
        }
        else
            return false;
    }
    public boolean withdraw(double amount)
    {
        if(balance<=0 || amount<=0 || amount>this.balance )
        {
            return false;
        }
            
        this.balance -= amount;
        this.transactionCount++;
        return true;
                     
    }
    
    private double calculateTransactionFee(double amount)
    {
       
         if(amount<500)
             return 5;
         else if(amount<=999.99)
             return 10;
         else
             return 15;
    }
    
    public boolean transfer(DigitalWallet reciever,double amount)
    {
        if(amount<=0)
           return false;
        if(reciever==null)
            return false;
        if(reciever==this)
            return false;
        if(this.balance< amount+calculateTransactionFee(amount))
            return false;
        else
        {
            reciever.balance += amount;
            this.balance -= (amount + calculateTransactionFee(amount));
            this.transactionCount ++;
            reciever.transactionCount ++;
            return true;
        }    
    }
   
   
}
