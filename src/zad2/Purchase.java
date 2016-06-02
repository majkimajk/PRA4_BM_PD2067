/**
 *
 *  @author Baran Michał PD2067
 *
 */

package zad2;


import java.beans.*;
import java.io.Serializable;

public class Purchase implements Serializable{

    private String prod, data;
    private double price;
    private PropertyChangeSupport changeSup = new PropertyChangeSupport(this);
    private VetoableChangeSupport vetoSup = new VetoableChangeSupport(this);


    //setter i getter dla prod
    public void setProd(String newProd) {

        prod = newProd;
    }

    public String getProd() {

        return prod;
    }

    //setter i getter dla data
    public synchronized void setData(String newData) {

        String oldData = data;
        data = newData;

        changeSup.firePropertyChange("data", oldData, newData);

    }

    public String getData() {
        return data;
    }

    // metody dodawania i usuwania słuchaczy
    public synchronized void addPropertyChangeListener(PropertyChangeListener propListener) {
        changeSup.addPropertyChangeListener(propListener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener propListener) {
        changeSup.removePropertyChangeListener(propListener);
    }


    // getter i setter dla price

    public double getPrice() {
        return price;
    }

    public synchronized void setPrice(double newPrice) throws PropertyVetoException {
        double oldPrice = price;
        vetoSup.fireVetoableChange("price", oldPrice, newPrice);

        price = newPrice;

    }

    // metody dodawania i usuwania słuchaczy

    public synchronized void addVetoableChangeListener(VetoableChangeListener vetoListener) {
        vetoSup.addVetoableChangeListener(vetoListener);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener vetoListener) {
        vetoSup.removeVetoableChangeListener(vetoListener);
    }

}  
