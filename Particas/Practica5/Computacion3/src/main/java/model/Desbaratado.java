/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author alanx
 */
public class Desbaratado {
    
    private final ModelView model = new DBQuery();
     
    public ArrayList<Integer> returnArrayId(){
        ArrayList<ModelGrafica> modelo = model.realAll();
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for(ModelGrafica e : modelo){
            resultado.add(e.getId());
        }
        return resultado;
    }
}
