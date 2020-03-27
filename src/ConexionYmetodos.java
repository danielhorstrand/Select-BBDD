import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ConexionYmetodos {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "SYSTEM";
	private String pwd = "Miro_5838";
	private Connection conexion;


	public ConexionYmetodos()  {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, usr, pwd);

				if(!conexion.isClosed()) {
					System.out.println("Conexión establecida");

					//conexion.close();
				}
				else
					System.out.println("Fallo en Conexión");


			}catch (Exception e) {
				System.out.println("ERROR en conexión con ORACLE");
				e.printStackTrace();
			}

		}
	public void MostrarTabla (String estado) throws SQLException {
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		Statement stm = conexion.createStatement();
		
		String selectsql = "SELECT DC.CUSTOMER_ID, DC.CUST_FIRST_NAME, DC.CUST_LAST_NAME, DC.CUST_CITY, DC.PHONE_NUMBER1 FROM DANIEL.DEMO_CUSTOMERS DC,DANIEL.DEMO_STATES DS WHERE DS.STATE_NAME='"+estado+"' AND DS.ST=DC.CUST_STATE";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		int contador= 0;
			System.out.println("Id cliente            Nombre            Apellido            Ciudad            teléfono.");
			while (resultado.next()) {
				contador++;
				System.out.println("    "+resultado.getInt(1)+"             "+resultado.getString(2)+"         "+resultado.getString(3)+"              "+resultado.getString(4)+"          "+resultado.getString(5));
			}

			if(contador==0) {
				System.out.println("----------------------------------------------No data found----------------------------------------------------");
			}

		
	}

}
