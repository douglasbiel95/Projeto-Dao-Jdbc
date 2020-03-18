package model.dao.implementacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DaoDepartamento;
import model.entidades.Departamento;

public class DaoDepartamentoJDBC implements DaoDepartamento {

	/* Classe responsável por executar os comandos com o banco, para a classe Departamento, com a tecnologia JDBC */
	
	/* Dependência da classe com um objeto da classe Connection, que realiza e armazena a conexão com o banco */
	private Connection conexaoBanco;
	
	public DaoDepartamentoJDBC(Connection conexaoBanco) {
		this.conexaoBanco = conexaoBanco;
	}
	
	/* Método que insere um vendedor ao banco de dados */
	@Override
	public void insert(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conexaoBanco.prepareStatement(
					" INSERT INTO DEPARTMENT "
					+ "(NAME) "
					+ "VALUES "
					+ "(?);"
					, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, departamento.getNomeDepartamento());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					departamento.setIdDepartamento(id);
				}
			}		
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fechaRecursosStatement(st);
			DB.fechaRecursosResultSet(rs);
		}
		
	}

	@Override
	public void update(Departamento departamento) {
		PreparedStatement st = null;
		
		try {
			st = conexaoBanco.prepareStatement(""
					+ "UPDATE Department "
					+ "SET name = ? "
					+ "WHERE id = ?");
			
			st.setString(1, departamento.getNomeDepartamento());
			st.setInt(2, departamento.getIdDepartamento());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conexaoBanco.prepareStatement(
					  "DELETE FROM Department "
					+ "WHERE id = ?;"
					);
			
			st.setInt(1, id);
			
			int rows = st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Não há Departamento com o Id informado!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conexaoBanco.prepareStatement(
					  "SELECT * FROM Department AS dep "
					+ "WHERE "
					+ "dep.id = ?;"
					);
			
			st.setInt(1, id);
			
			st.executeQuery();
			
			rs = st.getResultSet();
			
			if(rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setIdDepartamento(rs.getInt("Id"));
				departamento.setNomeDepartamento(rs.getString("Name"));
				DB.fechaRecursosResultSet(rs);
				DB.fechaRecursosStatement(st);
				return departamento;
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		Statement st = null;
		ResultSet rs = null;
		List<Departamento> list;
		
		
		try {
			
			st = conexaoBanco.createStatement();
			
			st.executeQuery(
					  "SELECT * FROM Department;"
					);
			
			rs = st.getResultSet();
			list = new ArrayList<>();
			
			while(rs.next()) {
				
				Departamento departamento= new Departamento();
				
				departamento.setIdDepartamento(rs.getInt("id"));
				departamento.setNomeDepartamento(rs.getString("Name"));
				
				list.add(departamento);
			}
			DB.fechaRecursosResultSet(rs);
			DB.fechaRecursosStatement(st);
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// Método que apenas instancia um objeto do tipo Departamento
	public static Departamento metodoInstDep(ResultSet resultadoConsultaBanco) throws SQLException {
		
		// busca na tabela de resposta o id do departamento e o nome do departamento e instancia o objeto Departamento
		Departamento departamentoAux = new Departamento(resultadoConsultaBanco.getInt("DepartmentId"),
				resultadoConsultaBanco.getString("DepName") );
		
		return departamentoAux;
	}
	
}
