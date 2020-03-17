package model.dao.implementacoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.DaoDepartamento;
import model.entidades.Departamento;

public class DaoDepartamentoJDBC implements DaoDepartamento {

	@Override
	public void insert(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Método que apenas instancia um objeto do tipo Departamento
	public static Departamento metodoInstDep(ResultSet resultadoConsultaBanco) throws SQLException {
		
		// busca na tabela de resposta o id do departamento e o nome do departamento e instancia o objeto Departamento
		Departamento departamentoAux = new Departamento(resultadoConsultaBanco.getInt("DepartmentId"),
				resultadoConsultaBanco.getString("DepName") );
		
		return departamentoAux;
	}

	@Override
	public List<Departamento> findByDepartment(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
