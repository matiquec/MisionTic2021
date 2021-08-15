package view;

import java.util.ArrayList;
import java.util.Scanner;

import java.sql.SQLException;
import controller.ControladorRequerimientosReto4;
import model.vo.ProyectoRankeadoCompras;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
//IMPORTANTE
//ADICIONAR LAS FUNCIONALIDADES PARA LOS NUEVOS REQUERIMIENTOS
//1) ¿Cuáles son los 10 proyectos ordenados de mayor a menor donde más dinero se ha invertido en compra de materiales?
//3) Bancos ordenados de mayor a menor según el área de construcción promedio de los proyectos que respaldan.
//5) Los materiales importados más comprados en los proyectos, mostrando cuántas compras se han hecho de cada uno. Desempatar alfabéticamente.

//Vista que se le daría al usuario
public class VistaRequerimientosReto4 {

    //Atributos
    //Controlador necesario para el funcionamiento de la vista
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    
    //Ejercicio reto 4

    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Reto 4 ejercicio 1. mostrar 10 proyectos de mayor inversión
     public static void requerimiento1(){

        System.out.println("-----10 Proyectos Mayor Gasto-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosCompras = controlador.consultarProyectosCompras10();
            

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");
            
            for (ProyectoRankeadoCompras inversion : rankingProyectosCompras) {
                System.out.printf("%d %s %.0f %s %n", 
                                    inversion.getId_proyecto(),
                                    inversion.getClasificacion(),
                                    inversion.getGasto_compra(),
                                    inversion.getSerial());
            };

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    //Reto 4 Ejercicio 3. Mostrar los bancos por área de proyectos
    public static void requerimiento3(){

        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");       

        try{

            ArrayList<BancoRankeadoAreaPromedio> rankingBancosArea = controlador.consultarBancosRankeadosAreaPromedio();
            System.out.println("Banco_Vinculado Area_Promedio");

            for (BancoRankeadoAreaPromedio banco : rankingBancosArea) {
                
                System.out.printf("%s\t%f %n", 
                    banco.getBancoVinculado(),
                    banco.getAreaPromedio()
                );

            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }



    //Reto 4 Ejercicio 5. Mostrar los materiales importados, los que más se han usado
    public static void requerimiento5(){

        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       

        try{

            ArrayList<MaterialRankeadoCompras> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosCompras();
            System.out.println("Nombre_Material Importado No_Compras");
            for (MaterialRankeadoCompras material_importado : rankingMaterialesImportados) {
                
                System.out.printf("%s\t%s\t%d %n", 
                material_importado.getNombre_Material(),
                material_importado.getImportado(),
                material_importado.getNo_compras()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    //------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------
    //Ejercicios de prueba
   

    
    //Funcionalidades extra (Crear, eliminar, otras consultas)


}
