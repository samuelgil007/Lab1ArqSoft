<%-- 
    Document   : newAccount
    Created on : 27/01/2017, 08:53:07 PM
    Author     : brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>

            <div class="container well">

                <div align="center">
                <c:if test="${param.error==1}">
                    <font color="red">Esa cedula ya existe</font>
                </c:if>
                <tr>  <h1>Registrarse</h1> </tr>
                <form action="servlet?action=insert" method="post">
                <table>
                    <tr>
                        <th><label><b>Username:</b></label></th>
                        <th>
                            <input type="text" placeholder="Enter Username" class="form-control" name="username" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th><label><b>Password:</b></label></th>
                        <th>
                            <input type="password" placeholder="Enter Password" class="form-control" name="password" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th><label><b>Nombre: </b></label></th>
                        <th>
                            <input type="text" placeholder="Nombre" class="form-control" name="nombre" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th><label><b>Cedula: </b></label></th>
                        <th>
                            <input type="text" placeholder="Cedula" class="form-control" name="cedula" required=""/>
                        </th>
                    </tr>
                 

                    <tr> 
                    <label><b>Registrarse como:</b></label>
                    <select name="tipo">
                        <option value="admin">Admin</option>
                        <option value="estudiante">Estudiante</option>

                    </select>
                    </tr>
                    <div class="break"></div>
                    </div>
                    <tr>
                        <td colspan="2">
                            (Imagen solo valida para estudiantes)
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insert">
                            <span class="glyphicon glyphicon-ok-sign"></span>
                            <input class="btn icon-btn btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>    
            </form> 
        </div>
        <br>
    </div>
</body>
</html>