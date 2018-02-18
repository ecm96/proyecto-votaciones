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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import paquetevotaciones.DAO.ConexionBBDD;
import paquetevotaciones.DAO.Operaciones;
import paquetevotaciones.MODELO.ApplicationErrorException;
import paquetevotaciones.MODELO.Censo;
/**
 *
 * @author Emilio
 */
public class ServletConsultarCenso extends HttpServlet {

    private Connection Conexion;
    private ConexionBBDD ConexBD;
    private Censo votantes;
   
    
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{ 
             votantes = new Operaciones().consultarcenso(Conexion);
             HttpSession session= request.getSession(true);
             session.setAttribute("ListadoCenso", votantes);
             response.sendRedirect("VISTA/Censo.jsp");
            }catch(ApplicationErrorException AEE){  
                out.println(AEE);           
                response.sendRedirect("VISTA/Errores.jsp?Error="+AEE);     
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
        processRequest(request, response);
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
        processRequest(request, response);
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
