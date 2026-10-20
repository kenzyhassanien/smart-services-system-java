/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart.services.system;

import java.util.Scanner;

/**
 *
 * @author Kenzy Hassanen
 */
public class OOPLab3 {
    public static void main(String[] args) {
        options();
    }
    public static void options()
    {
        Scanner input=new Scanner(System.in);
        int choice;
        do{
        System.out.println("Please select the service you would like to use from the following list:");
            System.out.println("1-Movie Ticket");
            System.out.println("2-Digital Wallet");
            System.out.println("3-Delivery Order");
        choice = input.nextInt();
         if (choice < 1 || choice > 3)
            System.out.println("Invalid choice, try again.");
        }while(choice < 1 || choice > 3);
        
        
       if(choice==1)
           testMovieTicket();
       else if(choice==2)
           testDigitalWallet();
       else if(choice==3)
           testDeliveryOrder();
    }
    public static void testMovieTicket()
    {
        System.out.println("Movie Ticket:");
         MovieTicket ticket = new MovieTicket("S1", "Spiderman", "Kenzy", "A1", 200);
         System.out.println("Ticket ID: " + ticket.getTicketId());
         System.out.println("Movie name: " + ticket.getMovieName());
         System.out.println("Cutomer name: " + ticket.getCustmorName());
         System.out.println("Seat number: " + ticket.getSeatNumber());
         System.out.println("Booking status: " + ticket.getBookingStatus());
         System.out.println("Ticket discount : " + ticket.getDiscount());
         System.out.println("Ticket price: " + ticket.getPrice());
         
         ticket.applyDiscount(10);
         System.out.println("Discount: " + ticket.getDiscount());
         ticket.applyDiscount(-5);
         ticket.applyDiscount(101);
         System.out.println("Discount after invalid discount entry: " + ticket.getDiscount());
         
         System.out.println("Book the ticket: " + ticket.book());
         System.out.println("Ticket booked? answer: " + ticket.getBookingStatus());
         System.out.println("Book again: " + ticket.book());
         System.out.println("Ticket still booked?: " + ticket.getBookingStatus());
         System.out.println("Final price when booked: " + ticket.calculateFinalPrice());
         
         ticket.setSeatNumber("B4");
         System.out.println("Seat is: " + ticket.getSeatNumber());
         
          System.out.println("Cancel booking: " + ticket.cancelBooking());
          System.out.println("Ticket booked?: " + ticket.getBookingStatus());
          System.out.println("Cancel again: " + ticket.cancelBooking());
          ticket.setSeatNumber("B5");
          System.out.println("Seat is: " + ticket.getSeatNumber());
        System.out.println("Book again after canceling: " + ticket.book());
        
        MovieTicket negticket = new MovieTicket("S2", "Spiderman", "Sara", "A2", -50);
        System.out.println("Price : "+ negticket.getPrice());
        
        MovieTicket zeroTicket = new MovieTicket("S3", "Spiderman", "Farida", "A3", 0);
        System.out.println("Can i book? answer: " + zeroTicket.book());
        System.out.println("Is the ticket booked?: " + zeroTicket.getBookingStatus());
        
        System.out.println();
    }
    
    public static void testDigitalWallet()
    {
        System.out.println("Digital Wallet");
        DigitalWallet wallet = new DigitalWallet("W0", "kenzy", 1000);
        System.out.println("Starting balance: " + wallet.getBalance());
        System.out.println("Transaction count: " + wallet.getTransactionCount());
     
        wallet.setOwnerName("Mohamed");
        System.out.println("Owner is: " + wallet.getOwnerName());
        wallet.setOwnerName("");
        System.out.println("Owner is: " + wallet.getOwnerName());
        
        DigitalWallet negativeWallet = new DigitalWallet("W1", "Nobody", -100);
        System.out.println("Balance after being negative:" + negativeWallet.getBalance());
        
        System.out.println("Deposit 500: " + wallet.deposit(500));
        System.out.println("Balance: " + wallet.getBalance());
        System.out.println("Transaction count: " + wallet.getTransactionCount());
        
        System.out.println("Deposit 0: " + wallet.deposit(0));
        System.out.println("Deposit negative number: " + wallet.deposit(-10));
        System.out.println("Balance still: " + wallet.getBalance());
        System.out.println("Transaction count: " + wallet.getTransactionCount());
        
        System.out.println("Withdraw 300: " + wallet.withdraw(300));
        System.out.println("Balance: " + wallet.getBalance());
        System.out.println("Transaction count: " + wallet.getTransactionCount());
        
        System.out.println("Withdraw 0: " + wallet.withdraw(0));
        System.out.println("Withdraw -5: " + wallet.withdraw(-5));

        System.out.println("Withdraw 20000: " + wallet.withdraw(20000));
        System.out.println("Balance still: " + wallet.getBalance());
        System.out.println("Transaction count: " + wallet.getTransactionCount());
        
        DigitalWallet sender = new DigitalWallet("W3", "Farida", 1000);
        DigitalWallet receiver = new DigitalWallet("W4", "Rana", 0);
        System.out.println("Transfer 100: " + sender.transfer(receiver, 100));
        System.out.println("Sender balance, paid 100 + 5 fee: " + sender.getBalance());
        System.out.println("Receiver balance: " + receiver.getBalance());
        System.out.println("Sender transaction count: " + sender.getTransactionCount());
        System.out.println("Receiver transaction count: " + receiver.getTransactionCount());
        
        System.out.println("Transfer to null: " + sender.transfer(null, 50));
        
        System.out.println("Transfer to itself: " + sender.transfer(sender, 50));
        
        System.out.println("Transfer 0: " + sender.transfer(receiver, 0));
        System.out.println("Transfer -20: " + sender.transfer(receiver, -20));
        
        System.out.println("Sender balance: " + sender.getBalance());
        System.out.println("Receiver balance: " + receiver.getBalance());
        System.out.println("Sender count: " + sender.getTransactionCount());
        System.out.println("Receiver count: " + receiver.getTransactionCount());
        
        DigitalWallet poor = new DigitalWallet("W5", "Poor", 100);
        DigitalWallet other = new DigitalWallet("W6", "Other", 0);
        System.out.println("Transfer 100: " + poor.transfer(other, 100));
        System.out.println("Poor wallet balance: " + poor.getBalance());
        System.out.println("Other wallet balance: " + other.getBalance());
        System.out.println("Poor wallet count: " + poor.getTransactionCount());
        System.out.println("Other wallet count: " + other.getTransactionCount());
        
        DigitalWallet rich = new DigitalWallet("R", "Rich", 10000);
        DigitalWallet target = new DigitalWallet("T", "Target", 0);

        double before = rich.getBalance();
        rich.transfer(target, 499.99);
        System.out.println("Money taken: " + (before - rich.getBalance()));

        before = rich.getBalance();
        rich.transfer(target, 500);
        System.out.println("Money taken: " + (before - rich.getBalance()));

        before = rich.getBalance();
        rich.transfer(target, 999.99);
        System.out.println("Money taken: " + (before - rich.getBalance()));

        before = rich.getBalance();
        rich.transfer(target, 1000);
        System.out.println("Money taken: " + (before - rich.getBalance()));

        System.out.println("Rich transactions count: " + rich.getTransactionCount());
        System.out.println("Target transactions count: " + target.getTransactionCount());

        System.out.println();
        

    }
    
    public static void testDeliveryOrder()
    {
        System.out.println("Dilevery Order");
        
         DeliveryOrder cashOrder = new DeliveryOrder("O1", "Kenzy", "Alexandria", 3, 300);
        System.out.println("New order paid?: " + cashOrder.getPaymentStatus());
        System.out.println("New order delivered?: " + cashOrder.getDeliveryStatus());
        System.out.println("Total: 300 + 50 delivery: " + cashOrder.calculateTotalCost());

        System.out.println("Deliver before paying: " + cashOrder.delivery());
        System.out.println("Delivered?: " + cashOrder.getDeliveryStatus());

        System.out.println("Pay by cash: " + cashOrder.payOrder());
        System.out.println("Paid?: " + cashOrder.getPaymentStatus());
        System.out.println("Pay again: " + cashOrder.payOrder());

        System.out.println("Deliver after paying: " + cashOrder.delivery());
        System.out.println("Delivered?: " + cashOrder.getDeliveryStatus());
        System.out.println("Deliver again: " + cashOrder.delivery());
        
        DeliveryOrder order1 = new DeliveryOrder("B1", "X", "Addr", 1, 499.99);
        System.out.println("Total for 499.99: " + order1.calculateTotalCost());

        DeliveryOrder order2 = new DeliveryOrder("B2", "X", "Addr", 1, 500);
        System.out.println("Total for 500: " + order2.calculateTotalCost());

        DeliveryOrder order3 = new DeliveryOrder("B3", "X", "Addr", 1, 999.99);
        System.out.println("Total for 999.99: " + order3.calculateTotalCost());

        DeliveryOrder order4 = new DeliveryOrder("B4", "X", "Addr", 1, 1000);
        System.out.println("Total for 1000: " + order4.calculateTotalCost());
        
        DigitalWallet wallet = new DigitalWallet("W8", "Ali", 1000);
        DeliveryOrder walletOrder = new DeliveryOrder("O2", "Ali", "Alexandria", 2, 600, wallet);
        System.out.println("Total: 600 + 30 delivery: " + walletOrder.calculateTotalCost());
        System.out.println("Pay with wallet: " + walletOrder.payOrder());
        System.out.println("Paid?: " + walletOrder.getPaymentStatus());
        System.out.println("Wallet balance: 1000 - 630: " + wallet.getBalance());
        System.out.println("Wallet transaction count: " + wallet.getTransactionCount());
        System.out.println("Deliver: " + walletOrder.delivery());
        
        DigitalWallet poorWallet = new DigitalWallet("W9", "Sara", 100);
        DeliveryOrder poorOrder = new DeliveryOrder("O3", "Sara", "Cairo", 1, 200, poorWallet);
        System.out.println("Pay with not enough money: " + poorOrder.payOrder());
        System.out.println("Paid?: " + poorOrder.getPaymentStatus());
        System.out.println("Wallet balance still: " + poorWallet.getBalance());
        System.out.println("Wallet transaction count: " + poorWallet.getTransactionCount());
        System.out.println("Deliver unpaid order: " + poorOrder.delivery());
        
        poorWallet.deposit(200);
        System.out.println("Pay after adding money (expected true): " + poorOrder.payOrder());
        
        DeliveryOrder order = new DeliveryOrder("O4", "Omar", "Giza", 1, 100);
        order.setDeliveryAddress("Maadi");
        System.out.println("Delivery address:"+order.getDeliveryAddress());
        order.setDeliveryAddress("");
        System.out.println("Delivery address:"+order.getDeliveryAddress());
        order.setCustomerName("Omar M.");
        System.out.println("Customer name:"+order.getCustomerName());
        order.setCustomerName("");
        System.out.println("Customer name:"+order.getCustomerName());
        order.setItemCount(0);
        System.out.println("Item count:"+order.getItemCount());
        order.setSubtotal(-1);
        System.out.println("Subtotal:"+order.getSubtotal());
        order.setSubtotal(700);
        System.out.println("Subtotal:"+order.getSubtotal());
        order.payOrder();
        order.setSubtotal(50);
        System.out.println("Subtotal:"+order.getSubtotal());
        
        DeliveryOrder badOrder = new DeliveryOrder("X", "", "", 0, -10);
        System.out.println("Empty customer name becomes: " + badOrder.getCustomerName());
        System.out.println("Empty address becomes: " + badOrder.getDeliveryAddress());
        System.out.println("Item count 0 becomes: " + badOrder.getItemCount());
        System.out.println("Subtotal -10 becomes: " + badOrder.getSubtotal());



    }
    
}
