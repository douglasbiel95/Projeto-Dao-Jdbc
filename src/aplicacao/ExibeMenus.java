package aplicacao;

public class ExibeMenus {

	// Classe que exibe os menus
	
	
	public static void exibePrimeiroMenu() {
		System.out.println("-----Menu de Seleção-----");
		System.out.println("1. Vendedor");
		System.out.println("2. Departamento");
		System.out.println("3. Sair");
	}
	
	public static void exibeOpCrudVendedor() {
		System.out.println("-----Escolha uma Opção-----");
		System.out.println("1. Inserir um novo Vendedor");
		System.out.println("2. Buscar um Vendedor");
		System.out.println("3. Fazer Update sobre um Vendedor");
		System.out.println("4. Excluir um Vendedor");
		System.out.println("5. Listar todos os Vendedores");
		System.out.println("6. Listar todos os Vendedores por Departamento");
		System.out.println("7. Exit");
	}
}
