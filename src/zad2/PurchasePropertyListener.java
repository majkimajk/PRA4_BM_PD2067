package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * Created by jedzu_000 on 2016-06-03.
 */
public class PurchasePropertyListener implements PropertyChangeListener, VetoableChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String oldData = (String) evt.getOldValue();
        String newData = (String) evt.getNewValue();
        System.out.println("Change value of:  data from: " + oldData + " to: " + newData);
    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        Double oldPrice = (Double) evt.getOldValue();
        Double newPrice = (Double) evt.getNewValue();
        if (newPrice <= 500.0) {
            throw new PropertyVetoException("Price change to: " + newPrice + " not allowed", evt);
        }
        else {
            System.out.println("Change value of: price from: " + oldPrice + " to: " + newPrice);
        }
    }
}
