package model.dao;

import db.DB;
import model.dao.implementacoes.DaoVendedorJDBC;


public class FabricaDao {

	// Classe auxiliar respons�vel por inst�nciar os Dao's
	
	// Opera��es static para instanciar os objetos Dao
	
	// M�todo que instancia e retorna um objeto do tipo DaoGenerica do tipo Vendedor
	public static DaoVendedor criaDaoVendedor() {
		return new DaoVendedorJDBC(DB.fazConexao());
	}
}
