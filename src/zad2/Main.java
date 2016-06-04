/**
 *
 *  @author Baran Michał PD2067
 *
 */

package zad2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    PurchasePropertyListener ppl = new PurchasePropertyListener();
    purch.addPropertyChangeListener(ppl);
    purch.addVetoableChangeListener(ppl);


    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);
      purch.setPrice(500.00);


    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }



}
