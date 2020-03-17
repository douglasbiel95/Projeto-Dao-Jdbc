package model.dao.implementacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBIntegrityException;
import db.DbException;
import model.dao.DaoVendedor;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class DaoVendedorJDBC implements DaoVendedor{

	// Classe responsável por executar os comandos com o banco, para a classe Vendedor, com a tecnologia JDBC
	
	// Dependência da classe com um objeto da classe Connection, que realiza e armazena a conexão com o banco
	private Connection conexaoBanco;
	
	// Construtor da classe
	public DaoVendedorJDBC(Connection conexaoBanco) {
		this.conexaoBanco = conexaoBanco;
	}
	
	// Método que insere um vendedor ao banco de dados
	@Override
	public void insert(Vendedor vendedor) {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
		PreparedStatement comandosEsperandoBanco = null;
		
		try {
			comandosEsperandoBanco = conexaoBanco.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS); // insere recuperando o id
			
			// ? = PlaceHolder, lugar aonde depois entra os valores, um para cada
			// Método set do objeto PreparedStatement troca o PlaceHolder pelo valor desejado
			comandosEsperandoBanco.setString(1, vendedor.getNomeVendedor());	// insere no banco o nome
			comandosEsperandoBanco.setString(2, vendedor.getEmailVendendor());	// insere no banco o email
			comandosEsperandoBanco.setDate(3, new java.sql.Date(vendedor.getDataNascimentoVendedor().getTime())); // insere no banco a data
			comandosEsperandoBanco.setDouble(4, vendedor.getSalarioBase());	 // insere no banco o salario
			comandosEsperandoBanco.setInt(5, vendedor.getDepartamento().getIdDepartamento());	// insere no banco o id do departamento
			
			int linhasAfetas = comandosEsperandoBanco.executeUpdate();	// executa o comando SQL
			
			// Teste que verifica se o comando foi realizado
			if (linhasAfetas > 0) {
				// Executou
				// Classe ResultSet representa um objeto contendo o resultado da consulta na forma de tabela
				ResultSet resultadoConsultaBanco = comandosEsperandoBanco.getGeneratedKeys();	// retorna o id do banco do vendedor inserido
				if (resultadoConsultaBanco.next()) {
					int idBanco = resultadoConsultaBanco.getInt(1); // retorna o id gerado no banco
					vendedor.setIdVendedor(idBanco);
				}
				DB.fechaRecursosResultSet(resultadoConsultaBanco);	// fecha o recurso
			}
			else {
				throw new DbException("Erro inexperado! Nenhuma insersão foi realizada");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			// Encerra o recurso
			DB.fechaRecursosStatement(comandosEsperandoBanco);
		}
		
	}

	// Método que realiza um update de um vendedor no banco
	@Override
	public void update(Vendedor vendedor) {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
				PreparedStatement comandosEsperandoBanco = null;
				
				try {
					comandosEsperandoBanco = conexaoBanco.prepareStatement(
							"UPDATE seller "
							+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
							+ "WHERE Id = ? "); // realiza o update de um vendedor que já esteja no banco
					
					// ? = PlaceHolder, lugar aonde depois entra os valores, um para cada
					// Método set do objeto PreparedStatement troca o PlaceHolder pelo valor desejado
					comandosEsperandoBanco.setString(1, vendedor.getNomeVendedor());	// faz o update do nome no banco 
					comandosEsperandoBanco.setString(2, vendedor.getEmailVendendor());	// faz o update do email no banco 
					comandosEsperandoBanco.setDate(3, new java.sql.Date(vendedor.getDataNascimentoVendedor().getTime())); // faz o update da data no banco 
					comandosEsperandoBanco.setDouble(4, vendedor.getSalarioBase());	 // faz o update do salario no banco 
					comandosEsperandoBanco.setInt(5, vendedor.getDepartamento().getIdDepartamento());	// faz o update do departamento no banco 
					comandosEsperandoBanco.setInt(6, vendedor.getIdVendedor());	// faz o update do id do vendedor
					
					comandosEsperandoBanco.executeUpdate();	// executa o comando SQL

				} catch (SQLException e) {
					throw new DbException(e.getMessage());
				}
				finally {
					// Encerra o recurso
					DB.fechaRecursosStatement(comandosEsperandoBanco);
				}
		
	}

	// Método que deleta um objeto do banco pelo id
	@Override
	public void deleteById(Integer id) {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
		PreparedStatement comandosEsperandoBanco = null;
		
		try {
			comandosEsperandoBanco = conexaoBanco.prepareStatement(
					"DELETE FROM seller "
					+ "WHERE Id = ? ");	// deleta pelo id
			
			comandosEsperandoBanco.setInt(1, id);	// troca o placeHolder pelo id passado por parâmetro
			
			int linhasAfetadas = comandosEsperandoBanco.executeUpdate(); // executa o update
			
			// Teste que verifica se houve a exclusão
			if (linhasAfetadas == 0) {
				// não houve exclusão, o id passado não existe
				throw new DbException("O Id informado não existe!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			// Encerra os recursos
			DB.fechaRecursosStatement(comandosEsperandoBanco);
		}
		
	}

	// Método que retorna um objeto do tipo Vendedor pelo Id no banco
	@Override
	public Vendedor findById(Integer id) {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
		PreparedStatement comandosEsperandoBanco = null;
		
		// Classe ResultSet representa um objeto contendo o resultado da consulta na forma de tabela
		ResultSet resultadoConsultaBanco = null;
		
		try {
			comandosEsperandoBanco = conexaoBanco.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"); // Comando sql, ? = placeHolder
			
			// ? = PlaceHolder, lugar aonde depois entra os valores, um para cada
			// Método set do objeto PreparedStatement troca o PlaceHolder pelo valor desejado
			comandosEsperandoBanco.setInt(1, id); // id passado pelo parâmetro
			
			resultadoConsultaBanco = comandosEsperandoBanco.executeQuery(); // executa a consulta e armazena o retorno em forma de tabela
			
			// Teste que verifica se houve algum resultado da consulta
			if (resultadoConsultaBanco.next()) {
				// retornou uma tabela
					// Converão dos dados que estão na tabela para uma instanciação de um objeto Vendedor
				
				// Objeto Departamento
				Departamento departamentoAux = DaoDepartamentoJDBC.metodoInstDep(resultadoConsultaBanco);
				
				// Objeto Vendedor
				Vendedor vendedorAux = metodoInstVend(resultadoConsultaBanco, departamentoAux);
				
				return vendedorAux;
				
			}
			return null;	// não existe vendedor com esse id no banco
			
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DBIntegrityException(e.getMessage());
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			// encerra os recuros
			DB.fechaRecursosResultSet(resultadoConsultaBanco);
			DB.fechaRecursosStatement(comandosEsperandoBanco);
		}
	}
	
	// Método que retorna todos os vendedores do banco
	@Override
	public List<Vendedor> findAll() {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
		PreparedStatement comandosEsperandoBanco = null;
		
		// Classe ResultSet representa um objeto contendo o resultado da consulta na forma de tabela
		ResultSet resultadoConsultaBanco = null;
		
		try {
			comandosEsperandoBanco = conexaoBanco.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name"); // Comando sql, ? = placeHolder
			
			resultadoConsultaBanco = comandosEsperandoBanco.executeQuery(); // executa a consulta e armazena o retorno em forma de tabela
			
			// Lista que irá conter o resultado da consulta
			List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
			
			// Map que irá conter o departamento do vendedor, para não haver uma repetição de instanciação do mesmo departamento
				// A chave será o valor do Id do departamento e o valor será o objeto do tipo Departamento
			Map<Integer, Departamento> mapDepartamento = new HashMap<>();
			
			// Teste que verifica se houve algum resultado da consulta
			while (resultadoConsultaBanco.next()) {
				// retornou uma tabela
					// Converão dos dados que estão na tabela para uma instanciação de um objeto Vendedor
				
				// O método get do mapDepartamento recebe o id do departamento como chave
					// e instancia o objeto do tipo Departamento
					// Se a chave(DepartmentId) for igual ao que já existe no map, o método get retorna null
						// Se não der null, o departemento é reaproveitado para a instanciação dos objetos Vendedor pertencentes aquele departamento
				Departamento departamentoAux = mapDepartamento.get(resultadoConsultaBanco.getInt("DepartmentId"));
				
				// Se o método get do map retornar null, quer dizer que aquele departamento não estava no map
				if (departamentoAux == null) {
					// Objeto Departamento
					departamentoAux = DaoDepartamentoJDBC.metodoInstDep(resultadoConsultaBanco);
					mapDepartamento.put(departamentoAux.getIdDepartamento(), departamentoAux);	// armazena o departamento no map
				}
				
				// Objeto Vendedor
				Vendedor vendedorAux = metodoInstVend(resultadoConsultaBanco, departamentoAux);
				
				// Armazena o vendedor na lista de vendedores
				listaVendedores.add(vendedorAux);
				
			}
			return listaVendedores;	// não existe vendedor com esse id no banco
			
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DBIntegrityException(e.getMessage());
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			// encerra os recuros
			DB.fechaRecursosResultSet(resultadoConsultaBanco);
			DB.fechaRecursosStatement(comandosEsperandoBanco);
		}
	}
	
	// Método que retorna o/os vendedor/vendedores contidos em um departamento
	@Override
	public List<Vendedor> findByDepartment(Departamento departamento) {
		// Classe PreparedStatemant permite montar uma consulta Sql deixando os parâmetros da consulta serem passados por último
		PreparedStatement comandosEsperandoBanco = null;
		
		// Classe ResultSet representa um objeto contendo o resultado da consulta na forma de tabela
		ResultSet resultadoConsultaBanco = null;
		
		try {
			comandosEsperandoBanco = conexaoBanco.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name"); // Comando sql, ? = placeHolder
			
			// ? = PlaceHolder, lugar aonde depois entra os valores, um para cada
			// Método set do objeto PreparedStatement troca o PlaceHolder pelo valor desejado
			comandosEsperandoBanco.setInt(1, departamento.getIdDepartamento()); // id passado pelo parâmetro
			
			resultadoConsultaBanco = comandosEsperandoBanco.executeQuery(); // executa a consulta e armazena o retorno em forma de tabela
			
			// Lista que irá conter o resultado da consulta
			List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
			
			// Map que irá conter o departamento do vendedor, para não haver uma repetição de instanciação do mesmo departamento
				// A chave será o valor do Id do departamento e o valor será o objeto do tipo Departamento
			Map<Integer, Departamento> mapDepartamento = new HashMap<>();
			
			// Teste que verifica se houve algum resultado da consulta
			while (resultadoConsultaBanco.next()) {
				// retornou uma tabela
					// Converão dos dados que estão na tabela para uma instanciação de um objeto Vendedor
				
				// O método get do mapDepartamento recebe o id do departamento como chave
					// e instancia o objeto do tipo Departamento
					// Se a chave(DepartmentId) for igual ao que já existe no map, o método get retorna null
						// Se não der null, o departemento é reaproveitado para a instanciação dos objetos Vendedor pertencentes aquele departamento
				Departamento departamentoAux = mapDepartamento.get(resultadoConsultaBanco.getInt("DepartmentId"));
				
				// Se o método get do map retornar null, quer dizer que aquele departamento não estava no map
				if (departamentoAux == null) {
					// Objeto Departamento
					departamentoAux = DaoDepartamentoJDBC.metodoInstDep(resultadoConsultaBanco);
					mapDepartamento.put(departamentoAux.getIdDepartamento(), departamentoAux);	// armazena o departamento no map
				}
				
				// Objeto Vendedor
				Vendedor vendedorAux = metodoInstVend(resultadoConsultaBanco, departamentoAux);
				
				// Armazena o vendedor na lista de vendedores
				listaVendedores.add(vendedorAux);
				
			}
			return listaVendedores;	// não existe vendedor com esse id no banco
			
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DBIntegrityException(e.getMessage());
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			// encerra os recuros
			DB.fechaRecursosResultSet(resultadoConsultaBanco);
			DB.fechaRecursosStatement(comandosEsperandoBanco);
		}
	}
	
	
	// Método que instacia um objeto do tipo Vendedor
	private Vendedor metodoInstVend(ResultSet resultadoConsultaBanco, Departamento departamentoAux) throws SQLException {
		 
		// Busca na tabela de resposta o nome, id, email, data de nascimento, salário e instancia o objeto do tipo Vendedor
			// com o objeto do tipo Departamento criado e passado como parâmentro de instanciação
		Vendedor vendedorAux = new Vendedor(resultadoConsultaBanco.getInt("Id"), resultadoConsultaBanco.getString("Name"),
				resultadoConsultaBanco.getString("Email"), resultadoConsultaBanco.getDate("BirthDate"),
				resultadoConsultaBanco.getDouble("BaseSalary"), departamentoAux);
			
			return vendedorAux;	// retorna o vendedor
	}

}
