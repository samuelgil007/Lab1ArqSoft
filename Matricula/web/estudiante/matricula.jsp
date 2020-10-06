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
    <body>

        <jsp:include page="menuEstudiante.jsp"></jsp:include>
            <h1 align="center">Matriculas</h1>

            <div class="container well">


                    <h1> <div align="center">
                        <c:if test="${param.error==1}">
                            <font color="red">Ya estas matriculado en esta materia.</font>
                        </c:if>
                        <c:if test="${param.error==2}">
                            <font color="green">Matriculado con exito.</font>
                        </c:if>
                        <c:if test="${param.error==3}">
                            <font color="green">Materia cancelada con exito.</font>
                        </c:if>
                        <c:if test="${param.error==4}">
                            <font color="red">Usted no estaba matriculado en el curso, entonces no puede cancelar.</font>
                        </c:if>
                </h1> </div>
        


                        
                    <c:forEach var="a" items="${busquedaMateria}"><div class="container well">
                        <div class="card " align="center" >                           
                                <h5 class="card-title"><b>${a.nombre}</b></h5>
                                <p class="card-text">${a.descripcion}</p>
                                <a class="card-link" onclick="return confirm('Esta seguro que desea matricular ${a.nombre}?')" href="servlet?action=matricular&codigo=${a.codigo}">Matricular</a>        
                                <a class="card-link" onclick="return confirm('Esta seguro que desea cancelar ${a.nombre}?')" href="servlet?action=cancelar&codigo=${a.codigo}">Cancelar</a>        
                            
                        </div></div>
                    </c:forEach>  

    </body>

</html>