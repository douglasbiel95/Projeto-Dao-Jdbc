package model.dao;

import db.DB;
import model.dao.implementacoes.DaoDepartamentoJDBC;
import model.dao.implementacoes.DaoVendedorJDBC;


public class FabricaDao {

	// Classe auxiliar responsável por instânciar os Dao's
	
	// Operações static para instanciar os objetos Dao
	
	// Método que instancia e retorna um objeto do DaoVendedor
	public static DaoVendedor criaDaoVendedor() {
		return new DaoVendedorJDBC(DB.fazConexao());
	}
	
	// Método que instancia e retorna um objeto do DaoDepartamento
	public static DaoDepartamento criaDaoDepartamento() {
		return new DaoDepartamentoJDBC(DB.fazConexao());
	}
}
