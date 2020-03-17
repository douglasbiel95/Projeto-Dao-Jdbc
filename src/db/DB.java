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

	// Classe que contém métodos static para conectar e desconectar do banco
	
	// Atributo
	private static Connection conn = null;
	
	// Método que carrega as propriedades contidas no arquivo db.properties
		// abre e lê o arquivo, e salva as propriedades em um objeto do tipo properties
	private static Properties carregaProperties() {
		
		// try with resources para abrir o arquivo
		try (FileInputStream fs = new FileInputStream("db.properties")) {
				Properties proprieades = new Properties();	// instância do objeto que ira conter as propriedades, obtida do arquivo
				proprieades.load(fs);	// faz a leitura do arquivo db.properties apontado pelo fileinputstream, e armazena as informações
				return proprieades;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// Método que conecta com o banco
	public static Connection fazConexao() {
		// se estiver null, executa o código
			// realizada apenas uma vez, pois a conexão ficará salva no objeto do tipo connection
		if (conn == null) {
			try {
				Properties propriedadesConexao = carregaProperties(); // objeto que recebe as propriedades do banco
				String urlBanco = propriedadesConexao.getProperty("dburl"); // String que recebe a url de endereço do banco de dados
				conn = DriverManager.getConnection(urlBanco, propriedadesConexao); // obtem a conexao com o banco
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return conn;
	}
	
	// Método que fecha a conexão com o banco
	public static void fechaConexao() {
		
		// Teste que verifica se existe uma conexãp
		if (conn != null) {
			try {
				conn.close();		// fecha a conexão
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Método que encerra os recursos do objeto Statement
	public static void fechaRecursosStatement(Statement st) {
		// se o objeto do tipo statement for != null, quer dizer que ainda está aberto
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Método que encerra os recursos do objeto ResultSet
	public static void fechaRecursosResultSet(ResultSet rs) {
		// se o objeto do tipo resultset for != null, quer dizer que ainda está aberto
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
