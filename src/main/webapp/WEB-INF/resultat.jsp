<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Simulation du crédit</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <h1>Simulation du crédit</h1>
        
        <dl>
        
            <dt>Montant</dt>
            <dd><%= request.getParameter("montant") %></dd>

            <dt>Apport</dt>
            <dd><%= request.getParameter("apport") %></dd>

            <dt>Taux</dt>
            <dd><%= request.getParameter("taux") %></dd>

            <dt>Mensualité</dt>
            <dd><%= request.getParameter("mensualite") %></dd>

            <dt>Durée</dt>
            <dd><%= request.getAttribute("duree") %></dd>

            <dt>TAEG</dt>
            <dd><%= request.getAttribute("taeg") %></dd>

        </dl>
        
    </body>
</html>