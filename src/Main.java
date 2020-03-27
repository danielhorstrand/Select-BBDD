import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConexionYmetodos con = new ConexionYmetodos();
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Introduce Estado de los EE.UU: ");
		String estado = in.nextLine();
		String estadoUpper = estado.toUpperCase();
		
		con.MostrarTabla(estadoUpper);
	}

}
