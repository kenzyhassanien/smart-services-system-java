/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package smart.services.system;

/**
 *
 * @author Kenzy Hassanen
 */
public class MovieTicket {
    private String ticketId;
    private String movieName;
    private String custmorName;
    private String seatNumber;
    private double price;
    private boolean bookingStatus;
    private double  discount;

    public MovieTicket(String ticketId, String movieName, String custmorName, String seatNumber, double price) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.custmorName = custmorName;
        this.seatNumber = seatNumber;
        this.bookingStatus=false;
        this.discount=0;
        if(price>=0)
        this.price = price;
        else
            this.price=0;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getCustmorName() {
        return custmorName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean getBookingStatus() {
        return bookingStatus;
    }

    public double getDiscount() {
        return discount;
    }

    public void setMovieName(String movieName) {
        if(movieName.equals(""))
        {
            System.out.println("Error! Enter a valid movie name.");
        }
        else
        {
        this.movieName = movieName;
        }
    }

    public void setCustmorName(String custmorName) {
         if(custmorName.equals(""))
        {
            System.out.println("Error! Enter a valid customer name.");
        }
         else
         {
        this.custmorName = custmorName;
         }
    }

    public void setSeatNumber(String seatNumber) {
         if(seatNumber.equals("") || getBookingStatus()==true)
        {
            System.out.println("Error! can't assign the seat number.");
        }
         else
         {
        this.seatNumber = seatNumber;
         }
    }

    public void setPrice(double price) {
         if(price<0)
        {
            System.out.println("Error! Enter a valid price.");
        }
         else
         {   
        this.price = price;
         }
    }
    
    public boolean book()
    {
        
        if(bookingStatus==(true))
        {
            System.out.println("Ticket already booked");
            return false;
        }
        else if(price<=0)
        {
            return false;
        } 
       
        bookingStatus=true;
        return true;
            
    }
    
    public boolean cancelBooking()
    {
        if(bookingStatus==false)
        {
            return false;
        }
          bookingStatus=false;
          return true;
           
    }
    
    public void applyDiscount(double discount)
    {
        if(discount>=0 && discount<= 100)
        {
            this.discount=discount;
        }
        else
            System.out.println("Invalid discount!");
        
    }
    
    public double calculateFinalPrice()
    {
        double Price= this.price - (((this.discount/100)*this.price));
        if(bookingStatus)
        {
            double bookingFee=0.1*Price;
            double finalPrice = Price + bookingFee;
            return finalPrice;
        }
        return Price;
        
    }
    
   
}
