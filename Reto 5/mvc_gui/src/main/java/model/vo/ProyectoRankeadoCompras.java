package model.vo;

//Clase para identificar los proyectos que más materiales compran
public class ProyectoRankeadoCompras {

    //Atributos
    private int id_proyecto;
    private String clasificacion;
    private double gasto_compra;
    private String Serial;

    public ProyectoRankeadoCompras(){

    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getGasto_compra() {
        return gasto_compra;
    }

    public void setGasto_compra(Double gasto_compra) {
        this.gasto_compra = gasto_compra;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    
    
}