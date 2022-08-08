import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static Connection getConnection() {

		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/conta", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conexao;
	}
}
