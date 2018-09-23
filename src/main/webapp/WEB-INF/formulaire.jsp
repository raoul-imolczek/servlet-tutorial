<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Crédit Immobilier</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <h1>Votre demande de crédit immobilier</h1>
        <form action="/servlet-tutorial/calculette-credit" method="GET">

            <label for="montant">Montant du projet :</label>
            <input name="montant" id="montant" value="<%= (request.getParameter("montant") == null) ? "" : request.getParameter("montant") %>" />
            <br />

            <label for="apport">Apport :</label>
            <input name="apport" id="apport" value="<%= (request.getParameter("apport") == null) ? "" : request.getParameter("apport") %>" />
            <br />

            <label for="taux">Taux :</label>
            <input name="taux" id="taux" value="<%= (request.getParameter("taux") == null) ? "" : request.getParameter("taux") %>" />
            <br />

            <label for="mensualite">Mensualité :</label>
            <input name="mensualite" id="mensualite" value="<%= (request.getParameter("mensualite") == null) ? "" : request.getParameter("mensualite") %>" />
            <br />
            
            <input type="submit" value="Simuler" />

        </form>
    </body>
</html>