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
public class Resultado {
  
    private ArrayList<Partido> resultado;

    public Resultado(ArrayList<Partido> resultado) {
        this.resultado = resultado;
    }

    public ArrayList<Partido> getResultado() {
        return resultado;
    }

    public void setResultado(ArrayList<Partido> resultado) {
        this.resultado = resultado;
    }
    
    
    
}
