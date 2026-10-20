/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart.services.system;

/**
 *
 * @author Kenzy Hassanen
 */
public class DeliveryOrder {
    private String orderId;
    private String customerName;
    private String deliveryAddress;
    private int itemCount;
    private double subtotal;
    private boolean deliveryStatus;
    private boolean paymentStatus;
    private String paymentMethod;
    private DigitalWallet wallet;

    public DeliveryOrder(String orderId, String customerName, String deliveryAddress, int itemCount, double subtotal) {
        this.orderId = orderId;
        
        if(customerName.equals(""))
            this.customerName="Unknown";
        else
        this.customerName = customerName;
        
        if(deliveryAddress.equals(""))
            this.deliveryAddress="Unknown";
        else
            this.deliveryAddress = deliveryAddress;
        
        if(itemCount<=0)
            this.itemCount=1;
        else
            this.itemCount = itemCount;
        
        if(subtotal<0)
            this.subtotal=0;
        else
        this.subtotal = subtotal;
        
        this.wallet=null;
        this.paymentMethod="cash";
        this.deliveryStatus=false;
        this.paymentStatus=false;
    }

    public DeliveryOrder(String orderId, String customerName, String deliveryAddress, int itemCount, double subtotal, DigitalWallet wallet) {
        this.orderId = orderId;
       if(customerName.equals(""))
            this.customerName="Unknown";
        else
        this.customerName = customerName;
        
        if(deliveryAddress.equals(""))
            this.deliveryAddress="Unknown";
        else
            this.deliveryAddress = deliveryAddress;
        
        if(itemCount<=0)
            this.itemCount=1;
        else
            this.itemCount = itemCount;
        
        if(subtotal<0)
            this.subtotal=0;
        else
        this.subtotal = subtotal;
        this.wallet=wallet;
        this.paymentMethod="wallet";
        this.deliveryStatus=false;
        this.paymentStatus=false;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setCustomerName(String customerName) {
        if(customerName.equals(""))
            System.out.println("Error!invalid customer name");
            else
        this.customerName = customerName;
    }

    public void setDeliveryAddress(String deliveryAddress) {
         if(deliveryAddress.equals(""))
            System.out.println("Error!invalid delivery address");
            else
        this.deliveryAddress = deliveryAddress;
    }

    public void setItemCount(int itemCount) {
        if(paymentStatus)
        {
            System.out.println("Error! can't change paid orders");
            return;
        }
        if(itemCount<=0)
            System.out.println("Error! item count has to be greater than 0");
        else
        this.itemCount = itemCount;
    }

    public void setSubtotal(double subtotal) {
        if(paymentStatus)
        {
            System.out.println("Error! can't change paid orders");
            return;
        }

        if(subtotal < 0)
            System.out.println("Error! invalid subtotal");
        else
          this.subtotal = subtotal;
    }
    
    private double calculateDeliveryCost()
    {
        
        if(this.subtotal<500)
            return 50;
        if(this.subtotal<=999.99)
            return 30;
        else
            return 10;
    }
    
    public double calculateTotalCost()
    {
        double delivery = calculateDeliveryCost();
        return this.subtotal+delivery;
    }
    
    public boolean payOrder()
    {
       if(paymentStatus==true)
       {
           System.out.println("Already paid!");
           return false;
       }
            
        if(this.paymentMethod.equals("wallet"))
        {
            if(wallet==null)
                return false;
            double total =calculateTotalCost();
            if(!(wallet.withdraw(total)))
            return false;
        }
       
        
            this.paymentStatus=true;
            return true;
    }
    
    public boolean delivery()
    {
        if(!(paymentStatus))
        {
            System.out.println("Can't deliver! Order is not paid yet");
            return false;
        }
        if(deliveryStatus)
        {
            System.out.println("Already delivered!");
            return false;
        }
        
        this.deliveryStatus=true;
        return true;
    }
    
   
    
}
