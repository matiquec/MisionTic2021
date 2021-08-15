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

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList;

public class Requerimiento3_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // private JButton btnRequerimiento3;
    private JTable jtProyectos;

    //Constructor realizar la composición de la ventana
    public Requerimiento3_GUI(ArrayList<BancoRankeadoAreaPromedio> proyectos){

        //Propiedades del frame
        setTitle("Reporte Bancos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);       

        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Banco", "Area Max"};
        this.jtProyectos = new JTable(this.formatoRegistros(proyectos, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtProyectos);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking área promedio de construcción proyectos"));
        panel.add(sp);     
        
        //Contenedor
        getContentPane().add(panel);        

        //Mostrar ventana/frame
        setSize(400,250);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private String[][] formatoRegistros(ArrayList<BancoRankeadoAreaPromedio> proyectos, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[proyectos.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < proyectos.size(); i++) {
            registros[i][0] = proyectos.get(i).getBancoVinculado();
            registros[i][1] = String.valueOf(String.format("%.2f", proyectos.get(i).getAreaPromedio()) ); 
                 
        }

        //Retornar registros en formato JTable
        return registros;

    }

      


}