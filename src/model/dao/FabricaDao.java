package model.dao;

import db.DB;
import model.dao.implementacoes.DaoDepartamentoJDBC;
import model.dao.implementacoes.DaoVendedorJDBC;


public class FabricaDao {

	// Classe auxiliar respons�vel por inst�nciar os Dao's
	
	// Opera��es static para instanciar os objetos Dao
	
	// M�todo que instancia e retorna um objeto do DaoVendedor
	public static DaoVendedor criaDaoVendedor() {
		return new DaoVendedorJDBC(DB.fazConexao());
	}
	
	// M�todo que instancia e retorna um objeto do DaoDepartamento
	public static DaoDepartamento criaDaoDepartamento() {
		return new DaoDepartamentoJDBC(DB.fazConexao());
	}
}
