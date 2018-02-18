/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetevotaciones.CONTROLADOR;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetevotaciones.DAO.ConexionBBDD;
import paquetevotaciones.MODELO.Votante;
import paquetevotaciones.MODELO.ApplicationErrorException;
import paquetevotaciones.DAO.Operaciones;

/**
 *
 * @author Emilio
 */
public class ServletAltaVotante extends HttpServlet {

    private Connection Conexion;
    String Descripcion;
    private ConexionBBDD ConexBD;
    private int id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private LocalDate fecha_nac;
    private String contraseña;

    //hay que copiar el init de los apuntes
    @Override
    public void init() throws ServletException {
        /* Establecemos la conexión, si no existe */ try {
            ConexBD = ConexionBBDD.GetConexion();
            Conexion = ConexBD.GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }
    //hay que poner el destroy de los apuntes

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //con getparameter me traigo los valores
            nif = request.getParameter("nif");

            nombre = request.getParameter("nombre");

            apellidos = request.getParameter("apellido");

            direccion = request.getParameter("direccion");

            contraseña = request.getParameter("contrasena");

            if ((request.getParameter("fecha_nac")).equals("") == false) {
                fecha_nac = LocalDate.parse(request.getParameter("fecha_nac"));
            } else {
                fecha_nac = null;
            }
            //creo el objeto votante con los valores traidos
            Votante ObjVotante = new Votante(id, nif, nombre, apellidos, direccion, fecha_nac, contraseña, 'N');
            //llamos a operaciones al metodo insertar votante
            try {
                new Operaciones().insertarVotante(ObjVotante, Conexion);
                response.sendRedirect("VISTA/MenuEntrada.jsp");
            } catch (ApplicationErrorException AEE) {
                out.println(AEE);
                response.sendRedirect("VISTA/Errores.jsp?Error=" + AEE);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String getParameter(String nif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
