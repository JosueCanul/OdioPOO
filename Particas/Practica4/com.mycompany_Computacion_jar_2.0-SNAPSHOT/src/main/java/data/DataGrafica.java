package data;

import java.sql.Date;

public class DataGrafica {
    private int id;
    private String ensambladora;
    private String model;
    private int generation;
    private Date year;

    public DataGrafica(String ensambladora, String model, int generation, Date year) {
        this.ensambladora = ensambladora;
        this.model = model;
        this.generation = generation;
        this.year = year;
    }

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
    
    
    
}
