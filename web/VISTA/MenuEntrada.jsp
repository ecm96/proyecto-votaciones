<%-- 
    Document   : MenuEntrada
    Created on : 01-dic-2017, 10:59:37
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
        <link rel="icon" href="imagenes/favicon.ico">
        <title>Votaciones</title>
    </head>
    <body>
        <section class="menu">
                <ul>
                    <li><a href="AltaVotante.jsp"><span class="fa fa-angle-down">ALTA VOTANTE</span></a></li>
                    <li><a href="../ServletConsultarCenso"><span class="fa fa-angle-down">CENSO</span></a></li>
                    <li><a href="../ServletResultado"><span class="fa fa-angle-down">RESULTADOS</span></a></li>
                    <li><a href="Autenticarse.jsp?Opcion=Baja"><span class="fa fa-angle-down">BAJA VOTANTE</span></a></li>
                    <li><a href="Autenticarse.jsp?Opcion=Votar"><span class="fa fa-angle-down">VOTAR</span></a></li>              
                </ul>
        </section>  
    </body>
</html>
