package com.mycompany.computacion;


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
        //Datos para definir la dimensión de la matriz 
        int filas = dataDinamica.size();
        ModelGrafica paracalcularColumnas = dataDinamica.get(0);
        
        String paraDividir;
        String[] columnasArray;
        int columnas = 5;
        
        //Definir los datos de las filas 
        Object[][] datos = new Object[filas][columnas];
        for (int i = 0; i < filas; i++) {
            paracalcularColumnas = dataDinamica.get(i);
            paraDividir = paracalcularColumnas.toString();
            columnasArray = paraDividir.split(",");
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = columnasArray[j];
            }
        }
        
        
        return datos;
    }
    public void numColum(){
        data.numColum();
    }
}
