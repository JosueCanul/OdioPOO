
package com.mycompany.computacion;

import data.Graficas;
import data.*;
import java.sql.Date;
import java.sql.SQLException;
public class Computacion {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Graficas prueba = new Graficas();
        
        //prueba.readForId(1);
        
        Date date = Date.valueOf("2019-10-10");
        DataGrafica pruebaGrafica = new DataGrafica("RYZEN", "RX", 760, date);
        
        prueba.readForId(1);
        
        
        //prueba.updateForId(pruebaGraficaDos, 3);
        
        //prueba.readForId(3);
        
        //prueba.deleteForCedula(5);
    }
}
