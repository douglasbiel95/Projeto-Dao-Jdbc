package db;

public class DBIntegrityException extends RuntimeException {

	// Classe que representa a exceção personalizada de integridade referêncial
	
	private static final long serialVersionUID = 1L;
	
	public DBIntegrityException(String mensagemErro) {
		super(mensagemErro);
	}

}
