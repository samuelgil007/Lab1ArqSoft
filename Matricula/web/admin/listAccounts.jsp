<%-- 
    Document   : listAccounts
    Created on : 27/01/2017, 08:52:24 PM
    Author     : brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menuAdmin.jsp"></jsp:include>
        <div class="container" style="width:400px; background-color: #e3e3e3; border-style:  solid;">
        <h1>Cuentas admin</h1>
        <c:forEach var="a" items="${admins}">
            Cedula: ${a.cedula}  || Nombre de usuario: ${a.username}||
           <a onclick="return confirm('Esta seguro?')" href="servlet?action=deleteAdmin&cedula=${a.cedula}">Borrar</a>        
           <hr/>
        </c:forEach>  
           </div>
    </p>
        <div class="container" style="width:400px; background-color: #e3e3e3; border-style:  solid;">
           <h1>Cuentas estudiantes</h1>
        <c:forEach var="a" items="${estudiantes}">
           Cedula: ${a.cedula}  || Nombre de usuario: ${a.username}||
           <a onclick="return confirm('Esta seguro?')" href="servlet?action=deleteEstudiante&cedula=${a.cedula}">Delete</a>        
           <hr/>
        </c:forEach>  
        </div>
    </body>
</html>
