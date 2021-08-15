package model.dao;
import model.vo.MaterialRankeadoCompras;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import util.JDBCUtilities;

//Clase para construir objetos de consulta
import java.sql.PreparedStatement;

//Clase para manejar la respuesta de la base de datos. Responde como un iterador o apuntador.
 import java.sql.ResultSet;

public class MaterialRankeadoComprasDao {
    
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        ArrayList<MaterialRankeadoCompras> ranking_material_compras = new ArrayList<>();
        String script_base = "SELECT  MaterialConstruccion.Nombre_Material, " + 
                                    "MaterialConstruccion.Importado, "+
                                    "COUNT(Compra.ID_Compra) AS No_Compras "+

                                    "FROM Compra "+

                            "INNER JOIN MaterialConstruccion ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion "+
                            "WHERE MaterialConstruccion.Importado=='Si' "+
                            "GROUP BY MaterialConstruccion.Nombre_Material "+
                            "ORDER BY No_Compras DESC, "+
                                    "MaterialConstruccion.Nombre_Material ASC "+
                                    
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
                //Cargar el registro actual del resultset en los valueobject de la clase lider
                //Crear un objeto tipo lider
                MaterialRankeadoCompras respuesta_materialrankeado = new MaterialRankeadoCompras();

                //Asignar los atributos al lider
                respuesta_materialrankeado.setNombre_Material(resultSet.getString("Nombre_Material"));
                respuesta_materialrankeado.setImportado(resultSet.getString("Importado"));
                respuesta_materialrankeado.setNo_compras(resultSet.getInt("No_Compras"));
                
                //Crear la lista con la información de tipo lider
                ranking_material_compras.add(respuesta_materialrankeado);
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

        return ranking_material_compras; 

    }
}
