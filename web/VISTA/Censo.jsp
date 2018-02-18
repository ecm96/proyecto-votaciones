<%-- 
    Document   : Censo
    Created on : 01-dic-2017, 9:33:42
    Author     : Emilio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="paquetevotaciones.MODELO.Votante"%>
<%@page import="paquetevotaciones.MODELO.Censo"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Listado Votantes</title>

    </head>
    <body id="bf">
        <br/>
        <h1 style="text-align: center; position: relative; top:10%;">Listado de Votantes</h1>
        <table width="292" height="248" border="1" align="center">
            <tr>
                <th colspan="6" scope="col">Listado de Votantes</th>
            </tr>
            <tr>
                <td style="background:blue">NIF</td>
                <td style="background:blue">Nombre</td>
                <td style="background:blue">Apellidos</td>
                <td style="background:blue">Dirección</td>
                <td style="background:blue">Fecha Nacimiento</td>
                <td style="background:blue">Votado</td>               
            </tr>
            <%
                Censo Objcenso = (Censo) session.getAttribute("ListadoCenso");
                ArrayList<Votante> listado = Objcenso.getCenso();
                for (int i = 0; i < listado.size(); i++) {
                    Votante v = listado.get(i);
            %>
            <tr>
                <td><%= v.getNIF()%></td>
                <td><%= v.getNombre()%></td>
                <td><%= v.getApellido()%></td>
                <td><%= v.getDireccion()%></td>
                <td><%= v.getFechaNac()%></td>
                <td><%= v.getVotado()%></td>

            </tr>
            <% }%>
        </table>
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

