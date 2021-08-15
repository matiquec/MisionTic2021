package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import org.w3c.dom.events.Event;

import controller.ControladorRequerimientosReto4;
import io.mazenmc.menuapi.items.ItemListener;
import model.vo.ProyectoRankeadoCompras;
import java.util.ArrayList;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import view.Requerimiento1_GUI;

public class MenuPrincipalGUI extends JFrame {
    //Atributos
    private JButton btn1;
    private JComboBox<String> lista_desplegable;
    private static JPanel panel;

    //Constructores
    public MenuPrincipalGUI(){
    }

    //Métodos
    public void IniciarApp(ControladorRequerimientosReto4 controlador){
        //Propiedades del frame
        setTitle("Menú Principal Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Agregar componentes de combobox
        String elementos[] = new String[] {"Inversion proyectos", "Bancos", "Materiales"};
        lista_desplegable = new JComboBox<String>(elementos);

        // //Agregar elementos a la lista desplegable
        // lista_desplegable.addItem("Reporte inversión de proyectos");
        // lista_desplegable.addItem("Reporte Bancos");
        // lista_desplegable.addItem("Reporte Materiales");
        
        // Agregar componentes de botones
        btn1 = new JButton();
        btn1.setText("Generar reporte");
        //Quién me va a escuchar
        btn1.addActionListener(controlador);
        //Qué voy a decir para que se haga lo que tengo asociado
        btn1.setActionCommand("");
        
        
        //Asociar los componentes al componente intermedio o al contenedor
        
        //Componente intermedio
        panel = new JPanel();
        panel.add(lista_desplegable);
        panel.add(btn1);

        //Contenedor
        getContentPane().add(panel);        

        //Mostrar ventana/frame
        setSize(400,90);
        setLocationRelativeTo(null);
        setLocation(500, 200);
        setVisible(true);

        

    }

    //Getters y Setters del atributo lista_desplegable
    public JComboBox<String> getLista_desplegable() {
        return lista_desplegable;
    }

    public void setLista_desplegable(JComboBox<String> lista_desplegable) {
        this.lista_desplegable = lista_desplegable;
    }


    
}
