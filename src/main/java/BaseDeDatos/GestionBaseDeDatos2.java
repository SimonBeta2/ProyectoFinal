/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;
import java.util.List;
import modelo.Pelicula;
/**
 *
 * @author Simon
 */
public class GestionBaseDeDatos2 {

    private final GestionBaseDeDatos1 GestionBaseDeDatos = new GestionBaseDeDatos1();

    public String createMovie(String id, String title, String imageUrl, String movieUrl) {
        if (id == null || title == null || imageUrl == null || movieUrl == null) {
            return "Error: Todos los campos son necesarios para crear una película.";
        }
        return GestionBaseDeDatos.agregarPelicula(new Pelicula(id, title, imageUrl, movieUrl)) ? "Película creada exitosamente." : "Error al crear la película.";
    }

    public String updateMovie(String id, String title, String imageUrl, String movieUrl) {
        if (id == null) {
            return "Error: El ID es necesario para actualizar.";
        }
        return GestionBaseDeDatos.actualizarPelicula(new Pelicula(id, title, imageUrl, movieUrl)) ? "Película actualizada exitosamente." : "Error al actualizar la película.";
    }

    public String deleteMovie(String id) {
        if (id == null) {
            return "Error: El ID es necesario para eliminar.";
        }
        return GestionBaseDeDatos.eliminarPelicula(Integer.parseInt(id)) ? "Película eliminada exitosamente." : "Error al eliminar la película.";
    }

    public List<Pelicula> listMovies() {
        return GestionBaseDeDatos.listarPeliculas();
    }
}
