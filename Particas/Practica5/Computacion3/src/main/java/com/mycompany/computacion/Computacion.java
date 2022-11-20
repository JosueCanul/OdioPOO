
package com.mycompany.computacion;

import model.ModelGrafica;
import model.DBQuery;
import java.sql.Date;
import java.util.ArrayList;
import model.ModelView;

public class Computacion {
    ModelView data = new DBQuery();
    public static void main(String[] args) {
        
        
        
        //prueba.readForId(1);
        
        Date date = Date.valueOf("2019-10-10");
        ModelGrafica pruebaGrafica = new ModelGrafica("RYZEN", "RX", 760, date);
        
        
        
        
        Esperoquesigavivo prueba = new Esperoquesigavivo();
        
        prueba.setFilas();
        prueba.numColum();
        //prueba.updateForId(pruebaGraficaDos, 3);
        
        //prueba.readForId(3);
        
        //prueba.deleteForCedula(5);
        
    }
   
}
