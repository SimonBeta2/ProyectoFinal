<%-- 
    Document   : catalogo
    Created on : 26/11/2024, 4:22:01 p. m.
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Creative - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/bootstrap/Root/dist/assets/favicon.ico" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/bootstrap/Root/dist/css/styles.css" rel="stylesheet" />
        <style>
            .corner-button {
                position: absolute;
                top: 10px;
                right: 10px;
                z-index: 1000;
            }
            .small-button {
                font-size: 10px; 
                padding: 5px 10px; 
                border-radius: 5px; 
            }
        </style>
    </head>
    <body id="page-top">
        <header class="masthead">
            <div class="corner-button">
                <a class="btn btn-primary small-button" href="${pageContext.request.contextPath}/bootstrap/Root/dist/VerificacionAdmin.jsp">Admin</a>
            </div>
            <div class="container mt-4">
                <h1>Catálogo de Películas</h1>
                <div class="row">
                  
                    <c:forEach var="pelicula" items="${peliculas}">
                        <div class="col-md-3 mb-4">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/${pelicula.imagenUrl}" class="card-img-top" alt="${pelicula.titulo}">
                                <div class="card-body">
                                    <h5 class="card-title">${pelicula.titulo}</h5>
                                    <a href="${pelicula.movieUrl}" class="btn btn-primary" target="_blank">Ver película</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            
        </header>
    </body>
</html>

