/*
 * 
 * HOOLAA, HE MODIFICADO LA CABECERA DE LA CLASE OPERACIONES. ECM
 * 
 */
package paquetevotaciones.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import paquetevotaciones.MODELO.Votante;
import paquetevotaciones.MODELO.ApplicationErrorException;
import paquetevotaciones.MODELO.Censo;
import paquetevotaciones.MODELO.Partido;
import paquetevotaciones.MODELO.Resultado;
import paquetevotaciones.MODELO.ValidadorDNI;

/**
 *
 * @author Emilio
 */
public class Operaciones {

    public void insertarVotante(Votante _ObjVotante, Connection _Conexion) throws ApplicationErrorException {
        try {
            LocalDate fechaactual = LocalDate.now();
            ValidadorDNI v = new ValidadorDNI(_ObjVotante.getNIF());

            if ((_ObjVotante.getNIF()).equals("") == true || (_ObjVotante.getNombre()).equals("") == true || (_ObjVotante.getApellido()).equals("") == true || (_ObjVotante.getDireccion()).equals("") == true || _ObjVotante.getFechaNac() == null || (_ObjVotante.getContrasena()).equals("") == true) {
                throw new SQLException("Campos nulos, por favor rellene todos los campos", "Alta Votante", 0);
            }

            if (v.validar() == false) {
                throw new SQLException("DNI incorrecto o falso", "Alta Votante", 0);
            }
            
            if(fechaactual.isAfter(_ObjVotante.getFechaNac()) == false){
                throw new SQLException("Fecha de nacimiento incorrecta, debe ser menor al día actual", "Alta Votante", 0);
            }
            
            String OrdenSql2 = "SELECT NIF FROM votante WHERE NIF='" + _ObjVotante.getNIF() + "';";
            Statement stmt;
            ResultSet rs;
            stmt = _Conexion.createStatement();
            rs = stmt.executeQuery(OrdenSql2);
            while (rs.next() == true) {
                throw new SQLException("El NIF ya se encuentra registrado", "Alta Votante", 0);
            }
            
            
            //preparamos las ordenes sql
            String OrdenSql = "INSERT INTO votante VALUES (null,?,?,?,?,?,AES_ENCRYPT(?,'emilio'),'N')";
            PreparedStatement PrepSt = _Conexion.prepareStatement(OrdenSql);
            PrepSt.setString(1, _ObjVotante.getNIF());
            PrepSt.setString(2, _ObjVotante.getNombre());
            PrepSt.setString(3, _ObjVotante.getApellido());
            PrepSt.setString(4, _ObjVotante.getDireccion());
            PrepSt.setDate(5, java.sql.Date.valueOf(_ObjVotante.getFechaNac()));
            PrepSt.setString(6, _ObjVotante.getContrasena());
            if (PrepSt.executeUpdate() == 0) {
                throw new SQLException("El NIF ya existe, no puede volver a registrarse", "Alta Votante", 0);
            }
        } catch (SQLException SQLE) {
            String MensajeError = SQLE.getMessage();
            int Codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Alta Votante", Codigoerror);
        }

    }

    public Resultado consultarresultados(Connection _Conexion) throws ApplicationErrorException {
        try {

            ArrayList<Partido> Lista = new ArrayList();
            String query = "SELECT * FROM partido";
            Statement stmt;
            ResultSet rs;
            stmt = _Conexion.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Partido = rs.getString("nombre");
                String Siglas = rs.getString("siglas");
                String Logo = rs.getString("logo");
                int N_votos = rs.getInt("numero_votos");

                Partido p = new Partido(ID, Partido, Siglas, N_votos, Logo);
                Lista.add(p);
            }
            Resultado r = new Resultado(Lista);
            return r;
        } catch (SQLException SQLE) {
            String MensajeError = SQLE.getMessage();
            int Codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Resultados", Codigoerror);
        }

    }

    public Censo consultarcenso(Connection _Conexion) throws ApplicationErrorException {
        try {

            ArrayList<Votante> Lista = new ArrayList();
            String query = "SELECT * FROM votante";
            Statement stmt;
            ResultSet rs;
            stmt = _Conexion.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NIF = rs.getString("NIF");
                String Nombre = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                String Direccion = rs.getString("Direccion");
                LocalDate Fechanac = LocalDate.parse(rs.getString("Fecha_nac"));
                String Contraseña = rs.getString("Contrasena");
                char Votado = (rs.getString("Votado")).charAt(0);

                Votante v = new Votante(ID, NIF, Nombre, Apellido, Direccion, Fechanac, Contraseña, Votado);
                Lista.add(v);
            }
            Censo c = new Censo(Lista);
            return c;
        } catch (SQLException SQLE) {
            String MensajeError = SQLE.getMessage();
            int Codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Censo", Codigoerror);
        }

    }

    public Votante autenticacion(Connection _Conexion, Votante votante) throws ApplicationErrorException {
        try {
            Votante v = null;
            if ((votante.getNIF()).equals("") == true || (votante.getContrasena()).equals("") == true) {
                throw new SQLException("Campos nulos, por favor rellene todos los campos", "Alta Votante", 0);
            }
            String OrdenSql2 = "SELECT NIF FROM votante WHERE NIF='" + votante.getNIF() + "';";
            Statement stmt;
            ResultSet rs;
            stmt = _Conexion.createStatement();
            rs = stmt.executeQuery(OrdenSql2);
            while (rs.next() == false) {
                throw new SQLException("El NIF es incorrecto", "Baja Votante", 0);
            }
            String OrdenSql3 = "SELECT * FROM votante WHERE NIF='" + votante.getNIF() + "' AND Contrasena=AES_ENCRYPT('" + votante.getContrasena() + "','emilio');";
            Statement stmt2;
            ResultSet rs2;
            stmt2 = _Conexion.createStatement();
            rs2 = stmt2.executeQuery(OrdenSql3);
            while (rs2.next() == false) {
                throw new SQLException("El password es incorrecto", "Baja Votante", 0);
            }
            rs2.beforeFirst();
            while (rs2.next()) {
                int ID = rs2.getInt("ID");
                String NIF = rs2.getString("NIF");
                String Nombre = rs2.getString("Nombre");
                String Apellido = rs2.getString("Apellido");
                String Direccion = rs2.getString("Direccion");
                LocalDate Fechanac = LocalDate.parse(rs2.getString("Fecha_nac"));
                String Contraseña = votante.getContrasena();
                char Votado = (rs2.getString("Votado")).charAt(0);

                v = new Votante(ID, NIF, Nombre, Apellido, Direccion, Fechanac, Contraseña, Votado);
            }

            String OrdenSql4 = "SELECT * FROM votante WHERE NIF='" + votante.getNIF() + "' AND Votado='N'";
            Statement stmt3;
            ResultSet rs3;
            stmt3 = _Conexion.createStatement();
            rs3 = stmt3.executeQuery(OrdenSql4);
            while (rs3.next() == false) {
                throw new SQLException("El votante ya ha depositado su voto", "Baja Votante", 0);
            }
            return v;
        } catch (SQLException e) {
            String MensajeError = e.getMessage();
            int Codigoerror = e.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Votar", Codigoerror);
        }
    }

    public void bajaVotante(Votante _ObjVotante, Connection _Conexion) throws ApplicationErrorException {
        try {

            if ((_ObjVotante.getNIF()).equals("") == true || (_ObjVotante.getContrasena()).equals("") == true) {
                throw new SQLException("Campos nulos, por favor rellene todos los campos", "Alta Votante", 0);
            }
            String OrdenSql2 = "SELECT NIF FROM votante WHERE NIF='" + _ObjVotante.getNIF() + "';";
            Statement stmt;
            ResultSet rs;
            stmt = _Conexion.createStatement();
            rs = stmt.executeQuery(OrdenSql2);
            while (rs.next() == false) {
                throw new SQLException("El NIF es incorrecto", "Baja Votante", 0);
            }
            String OrdenSql3 = "SELECT Contrasena FROM votante WHERE NIF='" + _ObjVotante.getNIF() + "' AND Contrasena=AES_ENCRYPT('" + _ObjVotante.getContrasena() + "','emilio');";
            Statement stmt2;
            ResultSet rs2;
            stmt2 = _Conexion.createStatement();
            rs2 = stmt2.executeQuery(OrdenSql3);
            while (rs2.next() == false) {
                throw new SQLException("El password es incorrecto", "Baja Votante", 0);
            }
            //preparamos las ordenes sql
            String OrdenSql = "DELETE FROM votante WHERE NIF=? AND Contrasena=AES_ENCRYPT(?,'emilio') AND Votado='N';";
            PreparedStatement PrepSt = _Conexion.prepareStatement(OrdenSql);
            PrepSt.setString(1, _ObjVotante.getNIF());
            PrepSt.setString(2, _ObjVotante.getContrasena());

            if (PrepSt.executeUpdate() == 0) {
                throw new SQLException("El votante no puede darse de baja una vez ha votado", "Baja Votante", 0);
            }
        } catch (SQLException SQLE) {
            String MensajeError = SQLE.getMessage();
            int Codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Alta Votante", Codigoerror);
        }
    }

    public void votar(Votante _ObjVotante, Partido Partido, Connection _Conexion) throws ApplicationErrorException, SQLException {
        try {
            _Conexion.setAutoCommit(false);

            String OrdenSql = "UPDATE votante SET Votado='S' WHERE NIF='" + _ObjVotante.getNIF() + "' AND Contrasena=AES_ENCRYPT('" + _ObjVotante.getContrasena() + "','emilio') AND Votado='N';";
            Statement Stmt = _Conexion.createStatement();
            if (Stmt.executeUpdate(OrdenSql) == 0) {
                throw new SQLException("No se pudo realizar el voto, el votante ya ha votado", "Votar", 0);
            }

            String OrdenSql2 = "UPDATE partido SET numero_votos=numero_votos+1 WHERE siglas='" + Partido.getSiglas() + "';";
            Statement Stmt2 = _Conexion.createStatement();
            if (Stmt2.executeUpdate(OrdenSql2) == 0) {
                throw new SQLException("No se pudo añadir el voto al partido", "Votar", 0);
            }
            _Conexion.commit();
        } catch (SQLException SQLE) {
            _Conexion.rollback();
            String MensajeError = SQLE.getMessage();
            int Codigoerror = SQLE.getErrorCode();
            throw new ApplicationErrorException(MensajeError, "Votar", Codigoerror);
        }

    }
}
