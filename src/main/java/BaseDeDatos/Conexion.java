/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author simon.betancurs
 */
public class Conexion {
    private static Connection conn = null;
    private static final String StringConn = "jdbc:mysql://localhost:3306/webpeliculas?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String password = "*Sbs1571456";

    private Conexion() {}

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(StringConn, user, password);
                System.out.println("Conexión única establecida.");
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error al establecer la conexión: " + e.getMessage());
            }
        }
        return conn;
    }
}


