/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetevotaciones.MODELO;
 
import java.util.ArrayList;
/**
 *
 * @author Emilio
 */
public class Censo {
    
    private ArrayList<Votante> Censo;

    public Censo(ArrayList<Votante> Censo) {
        this.Censo = Censo;
    }
  
    public ArrayList<Votante> getCenso() {
        return Censo;
    }

    public void setCenso(ArrayList<Votante> Censo) {
        this.Censo = Censo;
    }  
}
