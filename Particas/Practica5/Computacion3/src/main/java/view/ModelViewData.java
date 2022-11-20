package view;

import java.util.ArrayList;
import model.DBQuery;
import model.ModelGrafica;
import model.ModelView;

public class ModelViewData {
    ModelView data = new DBQuery(); // la interfaz ModelView solo contiene el READ por lo que solo se podra utilizar exclusivamente 
    //ese metodo cumpliendo con MVC de que la vista solo puede leer
    
    public Object[][] setFilas(){
        //Traspasar los datos de la base de datos
        ArrayList<ModelGrafica> dataDinamica = new ArrayList<ModelGrafica>();
        dataDinamica = data.realAll();
        //Datos para definir la dimensión de la matriz 
        int filas = dataDinamica.size();
        //Data completa
        //En este campo primero tomamos un elemento del array list y obtenesmos el toString seguido lo passamos 
        //a un array separando por el toString, así obteniendo la cantidad de columnas que se necesitan
        ModelGrafica paracalcularColumnas = dataDinamica.get(0);
        String paraDividir = paracalcularColumnas.toString();
        String[] columnasArray = paraDividir.split(",");
        int columnas = columnasArray.length;
        //Modelo para que si suge un cambio en el  modelo no se tenga que hacer aquí algún cambio 
        
        //Definir los datos de las filas 
        ModelGrafica modeloGraficaPibote; //Para que haga más sentido en el ciclo 
        Object[][] datos = new Object[filas][columnas];
        for (int i = 0; i < filas; i++) { //Honestamente esto es una mrd
            modeloGraficaPibote = dataDinamica.get(i);
            paraDividir = modeloGraficaPibote.toString();
            columnasArray = paraDividir.split(",");
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = columnasArray[j];
            }
        }
        return datos;
    }
    
    public String[] setcolum(){
        String[] columnas = {"id","ensambladora","model","generation","year"};
        return columnas;
    }
}
