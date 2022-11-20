package Clases;

import java.util.ArrayList;
import model.DBQuery;
import model.ModelGrafica;
import model.ModelView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alanx
 */
public class Esperoquesigavivo {
    ModelView data = new DBQuery();
    public Esperoquesigavivo(){
        
    }
    
    public Object[][] setFilas(){
        //Traspasar los datos de la base de datos
        ArrayList<ModelGrafica> dataDinamica = new ArrayList<ModelGrafica>();
        dataDinamica = data.realAll();
        //Definir los datos de las filas 
        Object[][] filas = null;
        int i = 0;
        for (ModelGrafica modeloGrafica: dataDinamica){
            String datosPorModelo = modeloGrafica.toString();
            filas[i] = datosPorModelo.split(",");
        }
        return filas;
    }
}
