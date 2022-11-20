package model;

import java.sql.Date;

//MOdelo de los registros que se harán en la base de datos 
public class ModelGrafica {
    private int id;
    private String ensambladora;
    private String model;
    private int generation;
    private Date year;
    
    public ModelGrafica(){
        
    }
    public ModelGrafica(String ensambladora, String model, int generation, Date year) {
        this.ensambladora = ensambladora;
        this.model = model;
        this.generation = generation;
        this.year = year;
    }
    public ModelGrafica(int id, String ensambladora, String model, int generation, Date year) {
        this.ensambladora = ensambladora;
        this.model = model;
        this.generation = generation;
        this.year = year;
        this.id = id;
    }
    
    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnsambladora() {
        return ensambladora;
    }

    public void setEnsambladora(String ensambladora) {
        this.ensambladora = ensambladora;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public Date getFechaSalida() {
        return year;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.year = fechaSalida;
    }

    @Override
    public String toString() {
        return id + "," + ensambladora + "," + model +  "," + generation + "," + year;
    }
    
    
    
}
