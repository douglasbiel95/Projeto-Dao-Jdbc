package db;

public class DBIntegrityException extends RuntimeException {

	// Classe que representa a exce��o personalizada de integridade refer�ncial
	
	private static final long serialVersionUID = 1L;
	
	public DBIntegrityException(String mensagemErro) {
		super(mensagemErro);
	}

}
