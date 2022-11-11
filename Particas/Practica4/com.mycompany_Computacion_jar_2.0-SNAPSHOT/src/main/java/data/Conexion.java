package data;

import desencriptar.RetornoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    private final RetornoDatos retorno = new RetornoDatos();
    private String database; // = "bne6qnbuksyijwgg6h2d";
    private String url; // = "jdbc:postgresql://bne6qnbuksyijwgg6h2d-postgresql.services.clever-cloud.com:5432/" + database;
    private String user; // = "usz5wrd9kmh4ndvthexq";
    private String password; // = "guHCceXBTAjcsh3Rjiks";
    
    public Conexion(){   }
    
    
    public Connection getConnection() {
        Connection cndb = null;
        try {
            this.database = retorno.recuperaDB();
            this.url = retorno.recuperarUrl() + this.database;
            this.user = retorno.recuperarUser();
            this.password = retorno.recuperarPassword();
            cndb = DriverManager.getConnection(url, user, password);
        
        } catch (SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        } 
        
        return cndb;
    }
}
