package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {

	public static Connection getConexao() {
		try {

			final String url = "jdbc:mysql://localhost:3306/estoque-sus";
			final String usuario = "root";
			final String senha = "123456";

			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}
}
