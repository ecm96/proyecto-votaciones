<%-- 
    Document   : AltaVotante
    Created on : 01-dic-2017, 8:59:25
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Alta Votantes</title>

    </head>
    <body id="bf">
        <br/>
        <h1 style="text-align: center; position: relative; top:10%;">Alta de Votantes</h1>
           <table id="tabform" height="550px" width="400px" >
                <tr id="contenido">
                    <td>
                        <form action="../ServletAltaVotante" method="post" entype="text/plain" id="textform1" name="textform">
                            <label>NIF<br><input type="text" name="nif" id="nif" maxlength="9" required></label>
                            <br/>
                            <br/>
                            <label>Nombre<br><input type="text" name="nombre" id="nombre"required></label>
                            <br/>
                            <br/>
                            <label>Apellidos <br> <input type="text" name="apellido" id="apellido" required/></label>
                            <br/>
                            <br/>
                            <label>Dirección <br> <input type="text" name="direccion" id="direccion" required/></label>
                            <br/>
                            <br/>
                            <label>Fecha de nacimiento <br> <input type="date" name="fecha_nac" id="fecha_nac" required/></label>
                            <br/>
                            <br/>
                            <label>Contraseña <br> <input type="password" name="contrasena" id="contrasena" max="16" required/></label>
                            <br/>
                            <br/>
                            <input type="submit" value="Enviar" onClick="submit()"/>
                        </form>
                    </td>
                </tr>
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
