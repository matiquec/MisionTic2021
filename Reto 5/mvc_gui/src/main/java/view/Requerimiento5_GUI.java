package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

import model.vo.MaterialRankeadoCompras;
import java.util.ArrayList;

public class Requerimiento5_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // private JButton btnRequerimiento3;
    private JTable jtProyectos;

    //Constructor realizar la composición de la ventana
    public Requerimiento5_GUI(ArrayList<MaterialRankeadoCompras> proyectos){

        //Propiedades del frame
        setTitle("Reporte materiales");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);       

        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Material", "Importado", "No Compras"};
        this.jtProyectos = new JTable(this.formatoRegistros(proyectos, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtProyectos);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking materiales más comprados"));
        panel.add(sp);     
        
        //Contenedor
        getContentPane().add(panel);        

        //Mostrar ventana/frame
        setSize(400,250);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private String[][] formatoRegistros(ArrayList<MaterialRankeadoCompras> proyectos, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[proyectos.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < proyectos.size(); i++) {
            registros[i][0] = proyectos.get(i).getNombre_Material(); 
            registros[i][1] = proyectos.get(i).getImportado();            
            registros[i][2] = String.valueOf(proyectos.get(i).getNo_compras());        
        }

        //Retornar registros en formato JTable
        return registros;

    }

      


}