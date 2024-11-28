/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

/**
 *
 * @author Simon
 */

import modelo.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionBaseDeDatos1 {
    
    Connection conn = Conexion.getConnection();
    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";

        try (
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(String.valueOf(rs.getInt("id")));
                pelicula.setTitulo(rs.getString("titulo"));               
                pelicula.setImagenUrl(rs.getString("imagen_url"));
                pelicula.setMovieUrl(rs.getString("movieUrl"));
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public boolean agregarPelicula(Pelicula pelicula) {
    String checkSql = "SELECT COUNT(*) FROM peliculas WHERE titulo = ?";
    String insertSql = "INSERT INTO peliculas (titulo, imagen_url, movieUrl) VALUES (?, ?, ?)";
    
    try (
         PreparedStatement checkStmt = conn.prepareStatement(checkSql);
         PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

        
        checkStmt.setString(1, pelicula.getTitulo());
        try (ResultSet rs = checkStmt.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                
                return false;
            }
        }

       
        insertStmt.setString(1, pelicula.getTitulo());
        insertStmt.setString(2, pelicula.getImagenUrl());
        insertStmt.setString(3, pelicula.getMovieUrl());
        int rowsAffected = insertStmt.executeUpdate();
        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        
        return false;
    }
}


    public boolean eliminarPelicula(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";

        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pelicula obtenerPeliculaPorId(int id) {
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        Pelicula pelicula = null;

        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setId(String.valueOf(rs.getInt("id")));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setImagenUrl(rs.getString("imagen_url"));
                pelicula.setMovieUrl(rs.getString("movieUrl"));            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    public boolean actualizarPelicula(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET titulo = ?, imagen_url = ?, movieUrl = ? WHERE id = ?";

        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(2, pelicula.getTitulo()); 
            pstmt.setString(3, pelicula.getImagenUrl());
            pstmt.setString(4, pelicula.getMovieUrl());
            pstmt.setInt(1, Integer.parseInt(pelicula.getId()));
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

