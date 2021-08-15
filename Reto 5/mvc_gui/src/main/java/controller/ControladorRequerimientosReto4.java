package controller;

import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
import model.vo.ProyectoRankeadoCompras;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.dao.MaterialRankeadoComprasDao;
import model.dao.ProyectoRankeadoComprasDao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.text.TabableView;

//View
import view.MenuPrincipalGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import view.Requerimiento1_GUI;
import view.Requerimiento5_GUI;
import view.Requerimiento3_GUI;


//Clase intermediaria entre la vista y el modelo
public class ControladorRequerimientosReto4 implements ActionListener{
    //El controlador va a alojar instancias de las clases del modelo que le interesan

    //Instancias de las clases del modelo (líder_dao)
    //Atributos
    private final ProyectoRankeadoComprasDao compra_materiales_dao;
    private final BancoRankeadoAreaPromedioDao ranking_bancos;
    private final MaterialRankeadoComprasDao ranking_materiales;

    //Atributos de la vista
    private final MenuPrincipalGUI menu_principal;

    //Atributos requerimientos vista

    //Constructor
    public ControladorRequerimientosReto4(){
        compra_materiales_dao = new ProyectoRankeadoComprasDao();
        ranking_bancos = new BancoRankeadoAreaPromedioDao();
        this.ranking_materiales = new MaterialRankeadoComprasDao();
        this.menu_principal = new MenuPrincipalGUI();
    
    }

    //Cada Requerimiento solicitado
    //Casos de uso

    //Reto 4 --------------------------------------------------------------------------------------------
    //Se deben mostrar los 10 proyectos que más invirtieron en materiales
    //Requerimiento 1. listar los 10 proyectos de mayor inversión en materiales

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        return this.compra_materiales_dao.consultarProyectosCompras10();
    }

    //Requerimiento 3. Listar los bancos por area máxima promedio de mayor a menor
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.ranking_bancos.consultarBancosAreaPromedioDesc();
    }
    
    //Requerimiento 5. Listar los materiales que más se han usado
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException{
        return this.ranking_materiales.rankingMaterialesComprasDescendente();
    }

    //Reto 5 -----------------------------------------------------------------------------------------------
    //Controlar la interfaz gráfica desde el controlador

    public void iniciarAplicacion(){
        menu_principal.IniciarApp(this);
    }

    //Acciones de los botones y las listas
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el evento asociado al botón
        //String actionCommnad = ((JButton)e.getSource()).getActionCommand();
        String reporte = menu_principal.getLista_desplegable().getSelectedItem().toString();
        
        switch(reporte){
            //Reportar los 10 proyectos que más gastan en materiales
            case "Inversion proyectos":     

                try{                
                    Requerimiento1_GUI tabla_requ1 = new Requerimiento1_GUI(this.consultarProyectosCompras10());
                    

                }catch(SQLException exc){
                    System.err.println("Ha ocurrido un error!"+exc.getMessage());
                }
                break;

            //Reportar los bancos que tienen proyectos por orden del area máxima promedio 
            case "Bancos":     

                try{

                    Requerimiento3_GUI tabla_requ3 = new Requerimiento3_GUI(this.consultarBancosRankeadosAreaPromedio());

                }catch(SQLException exc){
                    System.err.println("Ha ocurrido un error!"+exc.getMessage());
                }
                break;

            //Reportar los materiales que más se han usado en los proyectos
            case "Materiales":
                try{
                    Requerimiento5_GUI tabla_requ5 = new Requerimiento5_GUI(this.consultarMaterialesRankeadosCompras());

                }catch(SQLException exc){
                    System.err.println("Ha ocurrido un error!"+exc.getMessage());
                }
                break;
        }
        
    }

}
