<%-- 
    Document   : Autenticarse
    Created on : 13-dic-2017, 11:05:52
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="../VISTA/estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Autenticarse</title>
    </head>
    <body>
        <h1 style="text-align: center; position: relative; top:10%;">Autenticarse</h1>
        <div id="formula">
            <form action="../ServletDispatcher" method="post" entype="text/plain" id="textform5" name="textform">
                <table>
                    <tr>
                        <td>NIF</td>
                    </tr>
                    <tr>
                        <td><input type="text" id="usuariolog" name="usuario"/></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                    </tr>
                    <tr>
                        <td><input type="password" id="contraseñalog" name="contrasena"/></td>
                    </tr>
                    <tr>
                        <td>
                            <br/>
                            <input type="submit" value=" <%= request.getParameter("Opcion")%> " name="submit" onClick="submit()"/>
                            <br/>                    
                        </td>
                    </tr>            
                </table>
                <br/>
                <br/>           
            </form>

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
        <br/>
        <br/>
        <a id="link" href="MenuEntrada.jsp">Volver al menu de inicio...</a>
        <br/>
        <footer class="pie2"><br/>Proyecto Votaciones - Emilio Castillo Monteagudo</footer>
    </body>

</html>
