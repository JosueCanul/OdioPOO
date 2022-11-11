package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Debe de tener un finally cuando se comecte 
//La forma profesional es tener un pull de conexiones 
//Encriptar para que no esten en una variable de entorno y que estén en un archivo encriptado 
//Ver que pedo con DAOS
//RSA algoritmo de encriptamiento 

public class Graficas {

    private final Conexion cn = new Conexion(); //Final para que no pueda heredado
    private String sentencia = "";

    //En el modelo dao cada una de la data tiene un modelo crud de un modelo DAO 
    public void readForId(int id) {
        Connection newcn = cn.getConnection();
        try {

            sentencia = "SELECT * FROM graficas WHERE id = ?";
            ResultSet rs;
            PreparedStatement ps = newcn.prepareStatement(sentencia);
            //Recomendación del IDE así como todos los demas
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("ensambladora"));
                System.out.println(rs.getString("model"));
                System.out.println(rs.getString("generation"));
                System.out.println(rs.getString("year"));
            }
            
            newcn.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                newcn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    public void createGrafica(DataGrafica newGrafica) {
        Connection newcn = cn.getConnection();
        try {
            sentencia = "INSERT INTO graficas(ensambladora, model, generation, year ) VALUES(?,?,?,?)";
            PreparedStatement ps = newcn.prepareStatement(sentencia);

            ps.setString(1, newGrafica.getEnsambladora());
            ps.setString(2, newGrafica.getModel());
            ps.setInt(3, newGrafica.getGeneration());
            ps.setDate(4, newGrafica.getFechaSalida());
            //Numero de filas que fueron actualizaron
            
            ps.executeUpdate();
            newcn.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                newcn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    public void updateForId(DataGrafica newGrafica, int id) {
        Connection newcn = cn.getConnection();
        try {
            sentencia = "UPDATE graficas SET ensambladora = ?,model = ?,generation = ?,year = ? WHERE id = " + id;
            System.out.println(sentencia);
            PreparedStatement ps = newcn.prepareStatement(sentencia);

            ps.setString(1, newGrafica.getEnsambladora());
            ps.setString(2, newGrafica.getModel());
            ps.setInt(3, newGrafica.getGeneration());
            ps.setDate(4, newGrafica.getFechaSalida());
            
            ps.executeUpdate();
            newcn.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                newcn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    //Una clase que provea la conexio y otra que administre todos los Querys 

    public void deleteForId(int id) {
        Connection newcn = cn.getConnection();
        try {
            sentencia = "DELETE FROM graficas WHERE id = ?";
            PreparedStatement ps = newcn.prepareStatement(sentencia);

            ps.setInt(1, id);
            
            ps.executeUpdate();
            newcn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
