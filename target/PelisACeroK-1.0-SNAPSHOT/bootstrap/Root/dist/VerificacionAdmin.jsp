<%-- 
    Document   : PaginaAdmin1
    Created on : 26/11/2024, 8:57:55 p. m.
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%
    
    
    String errorMessage = null;

    
    if ("POST".equalsIgnoreCase(request.getMethod())) {
       
        String password = request.getParameter("password");

        
        String expectedPassword = "admin123";

        
        if (password != null && password.equals(expectedPassword)) {
            
            response.sendRedirect("PaginaAdmin.jsp");
            return; 
        } else {
           
            errorMessage = "Contraseña incorrecta. Inténtelo de nuevo.";
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Login</title>
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f8f9fa;
                margin: 0;
            }
            .login-container {
                background-color: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }
            .login-title {
                text-align: center;
                margin-bottom: 20px;
                font-weight: bold;
                font-size: 24px;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <div class="login-title">Inicio de Sesión - Admin</div>
            
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="alert alert-danger" role="alert">
                    <%= request.getAttribute("errorMessage") %>
                </div>
            <% } %>
            
            <form method="POST">
                
                <div class="mb-3">
                    <label for="password" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña" required>
                </div>
                
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Ingresar</button>
                </div>
            </form>
        </div>
    </body>
</html>

