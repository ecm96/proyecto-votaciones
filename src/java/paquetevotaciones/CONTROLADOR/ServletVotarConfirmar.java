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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paquetevotaciones.DAO.ConexionBBDD;
import paquetevotaciones.DAO.Operaciones;
import paquetevotaciones.MODELO.ApplicationErrorException;
import paquetevotaciones.MODELO.Partido;
import paquetevotaciones.MODELO.Votante;

/**
 *
 * @author Emilio
 */
public class ServletVotarConfirmar extends HttpServlet {

    private Connection Conexion;
    private ConexionBBDD ConexBD;
    String NIF;
    String Contrasena;
    String Partido;

    @Override
    public void init() throws ServletException {
        /* Establecemos la conexión, si no existe */ try {
            ConexBD = ConexionBBDD.GetConexion();
            Conexion = ConexBD.GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            NIF = request.getParameter("NIF");
            Contrasena = request.getParameter("Contrasena");
            Partido = request.getParameter("partidosdisponibles");
            Votante v = new Votante(NIF, Contrasena); 
            Partido p = new Partido(Partido);
            try {               
                new Operaciones().votar(v,p,Conexion);
                response.sendRedirect("VISTA/MenuEntrada.jsp");
            } catch (ApplicationErrorException AEE) {
                out.println(AEE);
                response.sendRedirect("VISTA/Errores.jsp?Error=" + AEE);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletVotarConfirmar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletVotarConfirmar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
