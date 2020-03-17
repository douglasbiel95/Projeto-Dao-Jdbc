package db;

public class DbException extends RuntimeException {

	// Classe que trata possiveis exceções do Banco de Dados
	
	private static final long serialVersionUID = 1L;

	// Construtor
	public DbException(String mensagemErro) {
		super(mensagemErro);
	}
}
