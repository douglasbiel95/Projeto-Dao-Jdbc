package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	// Classe que cont�m m�todos static para conectar e desconectar do banco
	
	// Atributo
	private static Connection conn = null;
	
	// M�todo que carrega as propriedades contidas no arquivo db.properties
		// abre e l� o arquivo, e salva as propriedades em um objeto do tipo properties
	private static Properties carregaProperties() {
		
		// try with resources para abrir o arquivo
		try (FileInputStream fs = new FileInputStream("db.properties")) {
				Properties proprieades = new Properties();	// inst�ncia do objeto que ira conter as propriedades, obtida do arquivo
				proprieades.load(fs);	// faz a leitura do arquivo db.properties apontado pelo fileinputstream, e armazena as informa��es
				return proprieades;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// M�todo que conecta com o banco
	public static Connection fazConexao() {
		// se estiver null, executa o c�digo
			// realizada apenas uma vez, pois a conex�o ficar� salva no objeto do tipo connection
		if (conn == null) {
			try {
				Properties propriedadesConexao = carregaProperties(); // objeto que recebe as propriedades do banco
				String urlBanco = propriedadesConexao.getProperty("dburl"); // String que recebe a url de endere�o do banco de dados
				conn = DriverManager.getConnection(urlBanco, propriedadesConexao); // obtem a conexao com o banco
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return conn;
	}
	
	// M�todo que fecha a conex�o com o banco
	public static void fechaConexao() {
		
		// Teste que verifica se existe uma conex�p
		if (conn != null) {
			try {
				conn.close();		// fecha a conex�o
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// M�todo que encerra os recursos do objeto Statement
	public static void fechaRecursosStatement(Statement st) {
		// se o objeto do tipo statement for != null, quer dizer que ainda est� aberto
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// M�todo que encerra os recursos do objeto ResultSet
	public static void fechaRecursosResultSet(ResultSet rs) {
		// se o objeto do tipo resultset for != null, quer dizer que ainda est� aberto
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
