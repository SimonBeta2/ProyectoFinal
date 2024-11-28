<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Panel de Administración</title>
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding: 20px;
                background-color: #f8f9fa;
            }
            .container {
                max-width: 800px;
                margin: auto;
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            .form-group {
                margin-bottom: 15px;
            }
            .textarea-container {
                margin-top: 20px;
            }
            .btn-container {
                display: flex;
                flex-direction: column;
                gap: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center mb-4">Panel de Administración</h1>
            
            <!-- Formulario para la información de la película -->
            <form id="movieForm" method="POST" action="${pageContext.request.contextPath}/AdminServlet">
                <div class="row">
                    <!-- Campos de texto -->
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="movieId">ID de la Película</label>
                            <input type="text" class="form-control" id="movieId" name="movieId">
                        </div>
                        <div class="form-group">
                            <label for="movieTitle">Título de la Película</label>
                            <input type="text" class="form-control" id="movieTitle" name="movieTitle">
                        </div>
                        <div class="form-group">
                            <label for="movieImage">URL de la Imagen</label>
                            <input type="text" class="form-control" id="movieImage" name="movieImage">
                        </div>
                        <div class="form-group">
                            <label for="movieUrl">URL de la pelicula</label>
                            <input type="text" class="form-control" id="movieUrl" name="movieUrl">
                        </div>
                    </div>
                    <!-- Botones para acciones -->
                    <div class="col-md-4 btn-container">
                        <button type="submit" class="btn btn-secondary" name="action" value="create">Crear</button>
                        <button type="submit" class="btn btn-secondary" name="action" value="update">Actualizar</button>
                        <button type="submit" class="btn btn-secondary" name="action" value="delete">Eliminar</button>
                        <button type="submit" class="btn btn-secondary" name="action" value="list">Listar</button>
                        <a href="${pageContext.request.contextPath}/CatalogoServlet" class="btn btn-secondary">Volver</a>
                        

                    </div>
                </div>
            </form>

            <!-- Área para mostrar las películas listadas -->
            <div class="textarea-container">
                <label for="movieList">Películas Listadas</label>
                <textarea id="movieList" class="form-control" rows="8" readonly>
                    
                    <% 
                        // Esta parte se puede rellenar dinámicamente desde un Servlet o una Base de Datos
                        String movies = (String) request.getAttribute("movies");
                        if (movies != null) {
                            out.print(movies);
                        } else {
                            out.print("No hay películas listadas.");
                        }
                    %>
                </textarea>
            </div>
        </div>
    </body>
</html>
