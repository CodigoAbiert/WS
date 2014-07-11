package predios_Manzana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Aqui se crea la coneccion a la base de datos
* @author franflan
*/
public class Coneccion {
	Connection conexion = null;
	public Connection getConnection(){		
	    
		try{
			Class.forName("org.postgresql.Driver").newInstance();
        }catch(Exception ff){
                System.out.print("No se encontro el Driver");
        }
		 try {
			 String host = "192.168.0.2";
			 String nombredb= "gev_zacatecas_reload";
			 String puerto="5432";
			 String url="jdbc:postgresql://"+host+"/"+nombredb;
			 String usuario = "portalcontenido";
			 String password = "rootGGWX";

			conexion=DriverManager.getConnection(url,usuario,password);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conexion;
	}

	public void closeConnection(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
