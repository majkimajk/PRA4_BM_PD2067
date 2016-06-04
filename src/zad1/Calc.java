/**
 *
 *  @author Baran Michał PD2067
 *
 */

package zad1;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calc {

    private String wynik;
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");



    public String doCalc(String cmd){

        try {
            wynik = engine.eval(cmd).toString();
        } catch (ScriptException e) {
            System.out.println("Invalid command to calc");
            System.exit(0);
        }
        return wynik;
    }
}  
