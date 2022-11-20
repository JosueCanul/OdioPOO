
package desencriptar;

import desencriptar.Descifrado;
import java.nio.file.Paths;
import java.util.Scanner;


public class RetornoDatos {
    //Instanciamos una clase Desencriptado que nos ayudara a obtener los valores del txt
    private Descifrado desencritar;
    private String clave;
    
    public RetornoDatos(){
        this.desencritar = new Descifrado(); //Creamos el objeto
        this.clave = "parasite";//Intanciamos la llave 
    }
    
    public String retorno(){
        
        //Abrimos el text
        try(Scanner lecturaArchivo = new Scanner(Paths.get("information.txt"))){
            String data = "";
            String line;
            while(lecturaArchivo.hasNextLine()){
                line = lecturaArchivo.nextLine();
                data += line + ",";
                
            }
            //Concateanmos cada una de las lineas en el archivo en el cual dependiendo de que linea sea será un valor para poder conectarss a la bs
            return data;
        } catch(Exception e){
            System.out.println("Archivo no encontrado");
        }
        return null;
    }
    
    //Aquí como ya se a mencionado cada linea del archivo txt le corresponde a un dato para acceder a la base de datos por lo cual
    //se separa y se anexa a un array de Strinng
    public String[] separa(){
        String dataCripto = retorno();
        String [] dataSeparada = dataCripto.split(",");
        return dataSeparada;
    }
    //Cada uno de los componentes del array de String es desencriptados por el metodo de la clase desencriptado así obteniendo 
    //los datos para que sea posible acceder a el
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
