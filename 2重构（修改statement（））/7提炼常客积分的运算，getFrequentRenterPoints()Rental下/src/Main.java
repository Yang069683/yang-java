import customer.*;
import movie.*;
import rental.*;
public class Main {
 public static void main(String[] args) {
     Customer customer = new Customer("Àî»ª");
     Rental rental =new Rental(new Movie("childrens",2),10);
     customer.addRental(rental);
     System.out.println(customer.statement());
     
 }
}