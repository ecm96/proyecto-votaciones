/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetevotaciones.MODELO;

import java.time.LocalDate;

/**
 *
 * @author Emilio
 */
public class Votante {

    private int ID;
    private String NIF;
    private String nombre;
    private String apellido;
    private String direccion;
    private LocalDate FechaNac;
    private String Contrasena;
    private char votado;

    public Votante() {}
    
    public Votante(int ID ,String NIF, String nombre, String apellido, String direccion, LocalDate FechaNac, String Contrasena, char votado) {
        this.ID= ID;
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.FechaNac = FechaNac;
        this.Contrasena = Contrasena;
        this.votado = votado;    
    }

    public Votante(String NIF, String Contrasena) {
        this.NIF = NIF;
        this.Contrasena = Contrasena;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(LocalDate FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public char getVotado() {
        return votado;
    }

    public void setVotado(char votado) {
        this.votado = votado;
    }

}
