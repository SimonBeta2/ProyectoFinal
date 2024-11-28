/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import BaseDeDatos.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pelicula;
/**
 *
 * @author Simon
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    
    private final GestionBaseDeDatos2 GestionBaseDeDatos = new GestionBaseDeDatos2();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String movieId = request.getParameter("movieId");
        String movieTitle = request.getParameter("movieTitle");
        String movieImage = request.getParameter("movieImage");
        String movieUrl = request.getParameter("movieUrl");

        String message = "";

        switch (action) {
            case "create":
                
                message = GestionBaseDeDatos.createMovie(movieId, movieTitle, movieImage, movieUrl);
                break;

            case "update":
                
                message = GestionBaseDeDatos.updateMovie(movieId, movieTitle, movieImage, movieUrl);
                break;

            case "delete":
                
                message = GestionBaseDeDatos.deleteMovie(movieId);
                break;

            case "list":
                
                StringBuilder titulos = new StringBuilder();
                List<Pelicula> peliculas = GestionBaseDeDatos.listMovies();
                for (Pelicula pelicula : peliculas) {
                    titulos.append(pelicula.getTitulo()).append("\n");
                }
                request.setAttribute("movies", titulos.toString());
                break;

            default:
                message = "Acción no válida.";
                break;
        }

        
        request.setAttribute("message", message);

        
        request.getRequestDispatcher("/bootstrap/Root/dist/PaginaAdmin.jsp").forward(request, response);
    }
}

