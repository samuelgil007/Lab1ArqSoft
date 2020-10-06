<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body >
        <jsp:include page="menuAdmin.jsp"></jsp:include>
        <h1>Bienvenido administrador ${admin}</h1>
        <form  method="post" action="servlet?action=buscarEst"  class="form-inline md-form mr-auto mb-4">
            Buscador de estudiantes:  <input class="form-control mr-sm-2" type="text" name="cedulaEst" placeholder="Ingrese la cedula" required="">
            <input class="btn btn-lg" type="submit" name="action" value="Buscar">
        </form>

        <div class="container" style="width:400px; background-color: #e3e3e3; border-style: solid;">
            <c:if test="${!empty busqueda}">
                <hr/>
                <h4>Estudiante<h4>
                        <img width="220" height="150" class="card-img-top" src="/Matricula/imagenes/${busqueda.imagen}" alt="No hay imagen">
                <h4 ><b><u>Nombre:</u></b> ${busqueda.nombre}</h4>
                <h4><b><u>Cedula:</u></b>  ${busqueda.cedula}</h4>
                <h4><b><u>Nombre de usuario:</u></b>  ${busqueda.username}</h4>
                <h4><b><u>Cursos matriculados:</u></b> </h4>
                <c:forEach var="a" items="${busquedaMateriax}">
                    <c:if test="${busqueda.cedula == a.cedula}">
                        <c:forEach var="b" items="${busquedaMateria}">
                            <c:if test="${a.codigo == b.codigo}">
                                <h4 class="card-title"> <b>-</b> ${b.nombre}</h4>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>

                <hr/>
            </c:if>
        </div>  </div> 
    </body>
</html>