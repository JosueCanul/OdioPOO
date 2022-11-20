
package controler;
import model.ModelGrafica;
import model.DBQuery;
import java.sql.Date;
import java.util.regex.Pattern;

//Parte juanta tanto el Modelo de las trajetas graficas como los Querys para pasandole los parametros del Objeto ModelGrafica 
//a DBQuery para poder implementar de momento solo se implementan metodos con los cuales se pueda lograr hacer cambios en la base de datos

public class Controler {
    
    private ModelGrafica modelgrafica;
    private final DBQuery dbquery;
    private int id;
    
    public Controler(){
        this.modelgrafica = null;
        this.dbquery = new DBQuery();
    }
    
    public void generate(String ensambladora, String model, int generation, Date year){
        if(ensambladora != null && model != null && generation != 0 && year != null){
            if(ensambladora.equals("NVIDIA")){
                modelgrafica = new ModelGrafica(ensambladora,model,generation, year);
            }else if(ensambladora.equals("RYZEN")){
                modelgrafica = new ModelGrafica(ensambladora,model,generation, year);
            }
        }else{
            System.out.println("Genera primero nueva data ");
        }
    }
    
    public void restart(){
        modelgrafica.setEnsambladora(null);
        modelgrafica.setFechaSalida(null);
        modelgrafica.setGeneration(0);
        modelgrafica.setModel(null);
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void create(){
        dbquery.createGrafica(modelgrafica);
    }
    
    public void read(){
       
    }
    
    public void update(){
        dbquery.updateForId(modelgrafica, id);
    }
    
    public void delete(){
        dbquery.deleteForId(id);
    }
    
    public static void main(String[] args) {
        
    }
}
