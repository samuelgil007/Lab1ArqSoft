<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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
        <jsp:include page="menuEstudiante.jsp"></jsp:include>
        <h1  style="color: #ffffff;" align="center">Bienvenido a la pagina de estudiantes ${estudiante}</h1>
        <c:if test="${img}">
            <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
                Suba una imagen para que lo identifiquen:
                <input type="file" name="uploadFile" />
                <br/><br/>
                <input type="submit" value="Upload" />
            </form>
        </c:if>
    </body>
</html>