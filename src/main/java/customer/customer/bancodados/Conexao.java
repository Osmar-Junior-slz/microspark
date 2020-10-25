package customer.customer.bancodados;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Conexao {

	public static Jdbi conectar() throws Exception {

		String url = "jdbc:postgresql://localhost/api";
		String usuario = "postgres";
		String senha = "osmar";
		Jdbi jdbi = Jdbi.create(url, usuario, senha);
		jdbi.installPlugin(new SqlObjectPlugin());

		
		

		return jdbi;

	}
	
}
