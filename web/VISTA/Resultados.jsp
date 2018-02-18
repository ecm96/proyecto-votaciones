<%-- 
    Document   : Censo
    Created on : 01-dic-2017, 9:33:42
    Author     : Emilio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="paquetevotaciones.MODELO.Partido"%>
<%@page import="paquetevotaciones.MODELO.Resultado"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Resultados</title>

    </head>
    <body id="bf">
        <br/>
        <h1 style="text-align: center; position: relative; top:10%;">Resultados Actuales</h1>
        <table width="292" height="248" border="1" align="center">
            <tr>
                <th colspan="6" scope="col">Resultados</th>
            </tr>
            <tr>
                <td style="background:#6699ff">Partido</td>
                <td style="background:#6699ff">Siglas</td>
                <td style="background:#6699ff">Logo</td>
                <td style="background:#6699ff">Nº Votos</td>                            
            </tr>
            <%
                Resultado Objresultado = (Resultado) session.getAttribute("ListadoPartidos");
                ArrayList<Partido> listado = Objresultado.getResultado();
                for (int i = 0; i < listado.size(); i++) {
                    Partido v = listado.get(i);
            %>
            <tr>
                <td><%= v.getNombre()%></td>
                <td><%= v.getSiglas()%></td>
                <td><img height="30px" width="30px" src="<%= v.getLogo()%>"/></td>
                <td><%= v.getN_votos()%></td>
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
