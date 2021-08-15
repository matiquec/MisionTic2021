package model.vo;

public class MaterialRankeadoCompras {
    
    private String Nombre_Material;
    private String Importado;
    private int No_compras;

    //constructor
    public MaterialRankeadoCompras(){

    }

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }

    public String getImportado() {
        return Importado;
    }

    public void setImportado(String importado) {
        Importado = importado;
    }

    public int getNo_compras() {
        return No_compras;
    }

    public void setNo_compras(int no_compras) {
        No_compras = no_compras;
    }

    
}
