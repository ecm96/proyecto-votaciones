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
public class Partido {

    private int ID;
    private String nombre;
    private String siglas;
    private int n_votos;
    private String logo;

    public Partido() {
    }

    public Partido(int ID,String nombre, String siglas, int n_votos, String logo) {
        this.ID = ID;
        this.nombre = nombre;
        this.siglas = siglas;
        this.n_votos = n_votos;
        this.logo = logo;
    }

    public Partido(String siglas) {
        this.siglas = siglas;
    }
 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getN_votos() {
        return n_votos;
    }

    public void setN_votos(int n_votos) {
        this.n_votos = n_votos;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
