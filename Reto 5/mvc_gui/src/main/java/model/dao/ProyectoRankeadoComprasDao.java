package model.dao;

import model.vo.ProyectoRankeadoCompras;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import util.JDBCUtilities;

//Clase para construir objetos de consulta
import java.sql.PreparedStatement;

//Clase para manejar la respuesta de la base de datos. Responde como un iterador o apuntador.
 import java.sql.ResultSet;

//contiene las funcionalidades para acceder a la base de datos
//Debe usar e instanciar atributos de model.vo


public class ProyectoRankeadoComprasDao {
    //Esta clase no tiene atributos, solo funcionalidades que acceden a la base de datos y construyen colecciones
    //Colecciones de value objects, mas que todo comportamientos de querys
    
    //Metodos CRUD

    //Hacer la consulta de los 10 proyectos que más invirtieron en materiales
    //Método de tipo arraylist de compra_material (Constructor vacio o con datos)
    public ArrayList<ProyectoRankeadoCompras> consultar_inversion_materiales() throws SQLException{
        ArrayList<ProyectoRankeadoCompras> lista_mas_inversion_material = new ArrayList<>();
        String script_base = "SELECT  Compra.ID_Proyecto, "+
                                    "Proyecto.Clasificacion, "+
                                    "SUM(Compra.Cantidad*MaterialConstruccion.Precio_Unidad) as Gasto_Compras, "+
                                    "Proyecto.Serial "+
                                    "FROM Compra "+
                            
                            "INNER JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion "+
                            "INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto "+
                            "GROUP BY Compra.ID_Proyecto "+
                            "ORDER BY Gasto_Compras DESC "+
                            "LIMIT 10 "+
                            ";";

        Connection conexion = null;

        try {

            //Conectar a la base y Realizar la consulta
            conexion = JDBCUtilities.getConnection();

            PreparedStatement statement = conexion.prepareStatement(script_base);

            //Resultado de que el statement ejecute el query de la base de datos
            //la consulta queda guardad en el resultset
            ResultSet resultSet = statement.executeQuery();

            //apuntador que registra si hay datos adelante, retornara verdadero hasta que no encuentre más registros
            while(resultSet.next()){
                //Cargar el registro actual del resultset en los valueobject de la clase compra_materiales en vo
                //Crear un objeto tipo compra_materiales
                ProyectoRankeadoCompras respuesta_compra_materiales = new ProyectoRankeadoCompras();

                //Asignar los atributos al lider
                respuesta_compra_materiales.setId_proyecto(resultSet.getInt("ID_Proyecto"));
                respuesta_compra_materiales.setClasificacion(resultSet.getString("Clasificacion"));
                respuesta_compra_materiales.setGasto_compra(resultSet.getDouble("Gasto_Compras"));
                respuesta_compra_materiales.setSerial(resultSet.getString("Serial"));
                
                //Crear la lista con la información de tipo lider
                lista_mas_inversion_material.add(respuesta_compra_materiales);
            }

            //Todo lo que tenga conexión a la base de datos debe cerrarse
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //TODO: handle exception
            System.err.println("Error al hacer la consulta de todos los líderes" + e);
        }finally{
            //Si hubo conexión hacer el cierre de la misma
            if (conexion!=null){
                conexion.close();
            }else{}
        }

        return lista_mas_inversion_material; 
    }


    //Ejercicio para el reto 4 con el nombre del método del reto 4
    
    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        ArrayList<ProyectoRankeadoCompras> lista_mas_inversion_material = new ArrayList<>();
        String script_base = "SELECT  Compra.ID_Proyecto, "+
                                    "Proyecto.Clasificacion, "+
                                    "SUM(Compra.Cantidad*MaterialConstruccion.Precio_Unidad) as Gasto_Compras, "+
                                    "Proyecto.Serial "+
                                    "FROM Compra "+
                            
                            "INNER JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion "+
                            "INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto "+
                            "GROUP BY Compra.ID_Proyecto "+
                            "ORDER BY Gasto_Compras DESC "+
                            "LIMIT 10 "+
                            ";";

        Connection conexion = null;

        try {

            //Conectar a la base y Realizar la consulta
            conexion = JDBCUtilities.getConnection();

            PreparedStatement statement = conexion.prepareStatement(script_base);

            //Resultado de que el statement ejecute el query de la base de datos
            //la consulta queda guardad en el resultset
            ResultSet resultSet = statement.executeQuery();

            //apuntador que registra si hay datos adelante, retornara verdadero hasta que no encuentre más registros
            while(resultSet.next()){
                //Cargar el registro actual del resultset en los valueobject de la clase compra_materiales en vo
                //Crear un objeto tipo compra_materiales
                ProyectoRankeadoCompras respuesta_compra_materiales = new ProyectoRankeadoCompras();

                //Asignar los atributos al lider
                respuesta_compra_materiales.setId_proyecto(resultSet.getInt("ID_Proyecto"));
                respuesta_compra_materiales.setClasificacion(resultSet.getString("Clasificacion"));
                respuesta_compra_materiales.setGasto_compra(resultSet.getDouble("Gasto_Compras"));
                respuesta_compra_materiales.setSerial(resultSet.getString("Serial"));
                
                //Crear la lista con la información de tipo lider
                lista_mas_inversion_material.add(respuesta_compra_materiales);
            }

            //Todo lo que tenga conexión a la base de datos debe cerrarse
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //TODO: handle exception
            System.err.println("Error al hacer la consulta de todos los líderes" + e);
        }finally{
            //Si hubo conexión hacer el cierre de la misma
            if (conexion!=null){
                conexion.close();
            }else{}
        }

        return lista_mas_inversion_material; 
    }



}
