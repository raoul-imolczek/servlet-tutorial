<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Hello World!</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <h1>Hello <%= request.getParameter("name") %>!</h1>
     </body>
</html>