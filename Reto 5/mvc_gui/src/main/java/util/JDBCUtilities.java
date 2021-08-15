package util;

//Clase de utilidades del software
//permite manejo de archivos, manejo de bases de datos
//en este caso, esta clase va a permitir la conexión con la base de datos

//Librerias necesarias
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

//Librerias archivos
import java.io.File;

public class JDBCUtilities {
    //Atributos

    //ubicación base de datos. Inmodificable (Relativa o absoluta)
    private static final String UBICACION_BD = "resources/ProyectosConstruccion.db"; //Ruta absoluta
    
    //Método proveer conexión
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;

        return DriverManager.getConnection(url);

    }

    //Método verificar conexión, porque sqlite crea la base si no existe
    public static boolean base_vacia(){
        boolean valor;
        File archivo = new File(JDBCUtilities.UBICACION_BD);
        if (archivo.length() == 0){
            valor =true;
        }else{
            valor = false;
        }
        return valor;
    }

    //Método inicializar base de datos
    
}
