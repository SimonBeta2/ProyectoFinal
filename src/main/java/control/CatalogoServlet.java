/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Simon
 */
import BaseDeDatos.*;
import modelo.Pelicula;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
    private static final GestionBaseDeDatos1 GestionBaseDeDatos = new GestionBaseDeDatos1();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        
        List<Pelicula> peliculas = GestionBaseDeDatos.listarPeliculas();
        System.out.println("Peliculas recuperadas: " + peliculas);
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher("/bootstrap/Root/dist/catalogo.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Método GET solicitado para CatalogoServlet");

        List<Pelicula> peliculas = GestionBaseDeDatos.listarPeliculas();
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher("/bootstrap/Root/dist/catalogo.jsp").forward(request, response); 
    }
}


