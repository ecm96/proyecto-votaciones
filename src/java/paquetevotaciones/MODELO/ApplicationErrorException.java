/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetevotaciones.MODELO;

/**
 *
 * @author Emilio
 */
public class ApplicationErrorException extends Exception{
    private String lugar;
    private int codigo;

    public ApplicationErrorException(String message,String lugar, int codigo) {
        super(message);
        this.lugar = lugar;
        this.codigo = codigo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
