<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Sample view!</title>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <h1>This is a sample protected view</h1>
        <dl>
            <dt>Foo</dt>
            <dd><%= request.getAttribute("foo") %></dd>
        </dl>
    </body>
</html>