<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios encontrados</title>
        <link href="amigos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Usuarios encontrados</h1>
        <table  class="listado">
            <tr>
                <th>Login</th> <th>Sexo</th> <th>Edad</th> <th>Localidad</th>
            </tr>
            <c:forEach items="${encontrados}" var="u">
                <tr>
                    <td><a href="verAmigo.do?amigo=${u.login}">${u.login}</a></td>
                    <td>${u.sexo}</td>
                    <td>${u.edad}</td>
                    <td>${u.localidad}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="busqueda.do">Nueva búsqueda</a>
    </body>
</html>
