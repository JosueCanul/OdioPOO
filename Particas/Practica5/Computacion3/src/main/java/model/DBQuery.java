package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//Debe de tener un finally cuando se comecte 
//La forma profesional es tener un pull de conexiones 
//Encriptar para que no esten en una variable de entorno y que estén en un archivo encriptado 
//Ver que pedo con DAOS
//RSA algoritmo de encriptamiento 

public class DBQuery implements ModelView{
   
    private final Conexion cn = new Conexion(); //Final para que no pueda heredado
    private String sentencia = "";
    //Cada uno sigue el mode lo unica que cambia es el tipo de Sentencia SQL que se desee realizar 
    /*Abre la conexión
    Prepara un PreparedStatement con el cual con cual deja pasar o no los datos proporcionados por el usuario para el Query 
    El PreparaedStatement integra los datos al Query comprobando uno a uno los datos
    Posteriormente se prepara ejecuta con un .executeQuery() o .executeUpdate()
    Si la acción ralizada es del tipo READ será necesario el uso de un Resultset el cual guardara la el resultado del Query
    siendo que a modo de .next() revisará si sigue existendo valores retornados de la base de datos
    
    Si es un CREATE UPDATE o DELETE se utilizara el .executeUpdate() el cual tendrá un valor de retorno de un entero que marcará 
    el número de filas que feron modificadas o cambios hechos
    
    Cierra la conexion con .close()
    */

    //En el modelo dao cada una de la data tiene un modelo crud de un modelo DAO 
    @Override
    public ArrayList<ModelGrafica> realAll() {
        
        ArrayList<ModelGrafica> graficas = new ArrayList<>();
        ModelGrafica modeloGrafica = new ModelGrafica();
        Connection newcn = cn.getConnection();
        try {

            sentencia = "SELECT * FROM graficas ";
            ResultSet rs;
            Statement st = newcn.createStatement();
            rs = st.executeQuery(sentencia);
            //Recomendación del IDE así como todos los demas
            while (rs.next()) {
                
                int id =(Integer.valueOf(rs.getString("id")));
                String ensambladora = (rs.getString("ensambladora"));
                String model = (rs.getString("model"));
                int generation = rs.getInt("generation");
                Date date = Date.valueOf(rs.getString("year"));
                
                graficas.add(new ModelGrafica(id, ensambladora, model, generation, date));
            }

            newcn.close();
            rs.close();
            return graficas;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                newcn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public void createGrafica(ModelGrafica newGrafica) {
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
            ps.close();
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

    public void updateForId(ModelGrafica newGrafica, int id) {
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
            ps.close();
            newcn.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                newcn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
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
            ps.close();
            newcn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void numColum() {
        Connection newcn = cn.getConnection();
        try{
            sentencia = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name = 'graficas'";
            Statement st = newcn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            System.out.println(rs);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
