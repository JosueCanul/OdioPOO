
package desencriptar;

import desencriptar.AES;
import java.nio.file.Paths;
import java.util.Scanner;


public class RetornoDatos {
    private AES desencritar;
    private String clave;
    
    public RetornoDatos(){
        this.desencritar = new AES();
        this.clave = "parasite";
    }
    
    public String retorno(){
        
        try(Scanner lecturaArchivo = new Scanner(Paths.get("information.txt"))){
            String data = "";
            String line;
            while(lecturaArchivo.hasNextLine()){
                line = lecturaArchivo.nextLine();
                data += line + ",";
                
            }
            return data;
        } catch(Exception e){
            System.out.println("Archivo no encontrado");
        }
        return null;
    }
    
    public String[] separa(){
        String dataCripto = retorno();
        String [] dataSeparada = dataCripto.split(",");
        return dataSeparada;
    }
    
    public String recuperaDB(){
        String [] dataSeparada = separa();
        String db = dataSeparada[0];
        
        String database = this.desencritar.desencriptar(db, "parasite");
        return database;
    }
    
    public String recuperarUrl(){
        String [] dataSeparada = separa();
        String url = dataSeparada[1];
        
        String urldesen = this.desencritar.desencriptar(url, "parasite");
        return urldesen;
    }
    
    public String recuperarUser(){
        String [] dataSeparada = separa();
        String user = dataSeparada[2];
        
        String useresen = this.desencritar.desencriptar(user, "parasite");
        return useresen;
    }
    
    public String recuperarPassword(){
        String [] dataSeparada = separa();
        String password = dataSeparada[3];
        
        String passwordsen = this.desencritar.desencriptar(password, "parasite");
        return passwordsen;
    }
}
