<%-- 
    Document   : Votar
    Created on : 16-dic-2017, 20:33:16
    Author     : Emilio
--%>

<%@page import="paquetevotaciones.MODELO.Partido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetevotaciones.MODELO.Resultado"%>
<%@page import="paquetevotaciones.MODELO.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Votación</title>

    </head>
    <body id="bf">
        <br/>
        <h1 style="text-align: center; position: relative; top:10%;">Datos del Votante</h1>
        <form action="../ServletVotarConfirmar" method="post" entype="text/plain" id="textform1" name="textform">
            <table width="292" height="248" border="1" align="center">
                <%
                    Votante v = (Votante) session.getAttribute("votante");

                %>
                <tr>
                    <td style="background:blue">NIF</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="NIF" id="NIF" value="<%= v.getNIF()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /><input type="hidden" name="Contrasena" id="Contrasena" value="<%= v.getContrasena()%>"/></td>
                </tr>
                <tr>
                    <td style="background:blue">Nombre</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="Nombre" id="Nombre" value="<%= v.getNombre()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /></td>
                </tr>
                <tr>
                    <td style="background:blue">Apellido</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="Apellido" id="Apellido" value="<%= v.getApellido()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /></td>
                </tr>
                <tr>
                    <td style="background:blue">Dirección</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="Direccion" id="Direccion" value="<%= v.getDireccion()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /></td>
                </tr>
                <tr>
                    <td style="background:blue">Fecha Nacimiento</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="Fechanac" id="Fechanac" value="<%= v.getFechaNac()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /></td>
                </tr>
                <tr>
                    <td style="background:blue">Votado</td>
                </tr>
                <tr>
                    <td><input type="text" readonly="readonly" name="Votado" id="Votado" value="<%= v.getVotado()%>" contenteditable="true" style="background:#0099cc; color:white; text-align: center; width: 98%" /></td>
                </tr>
                <tr>
                    <td colspan="2">Partido a Votar
                        <br/> 
                        <br/>
                        <input type="submit" value=" Votar " onclick="submit()"/> <a href="../index.jsp"><input type="button" value=" Volver "/></a>
                        <br/> 
                        <br/>
                        <label>Partidos<br>

                            <select id="partidosdisponibles" name="partidosdisponibles">
                                <%
                                    Resultado Objcenso = (Resultado) session.getAttribute("partidos");
                                    ArrayList<Partido> listado = Objcenso.getResultado();
                                    for (int i = 0; i < listado.size(); i++) {
                                        Partido p = listado.get(i);
                                %>                             
                                <option value="<%= p.getSiglas()%>" ><%= p.getNombre()%></option>                               
                                <% }%>
                            </select>

                        </label>
                        <br/>
                        <br/>                 
                    </td>                           
                </tr>
            </table>
        </form>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <a id="link" href="MenuEntrada.jsp">Volver al menu de inicio...</a>
        <br/>
        <footer class="pie2"><br/>Proyecto Votaciones - Emilio Castillo Monteagudo</footer>
    </body>
</html>

