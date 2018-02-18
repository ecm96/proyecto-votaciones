<%-- 
    Document   : Errores
    Created on : 03-dic-2017, 1:48:30
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String error = (String)request.getParameter("Error"); %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Error</title>

    </head>
    <body id="bf">
        <br/>
        <div id="formula">
            <table id="tabform" height="550px" width="400px" align="center">
                <tr>
                    <td>
                        <h1 style="color:white;"><% out.println(error); %></h1>
                    </td>
                </tr>
            </table>
        </div>
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
