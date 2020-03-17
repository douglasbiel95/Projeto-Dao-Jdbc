package aplicacao;

import java.text.ParseException;
import java.util.Scanner;

import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import model.entidades.enums.TipoVendedor;
import servico.ServicoVendedor;

public class Programa {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub

		ServicoVendedor servicoVendedor = new ServicoVendedor();
		
		try (Scanner entrada = new Scanner(System.in)) {
			
			int escolhaMenu;
			do {
				// Escolha entre Vendedor e Departamento
				ExibeMenus.exibePrimeiroMenu();
				escolhaMenu = entrada.nextInt();
				
				switch (escolhaMenu) {
				case 1:
					int menuVendedor;
					/* Menu Crud Vendedor */
					do {
						ExibeMenus.exibeOpCrudVendedor();
						menuVendedor = entrada.nextInt();
						entrada.nextLine();
						if (menuVendedor <= TipoVendedor.values().length) {
							TipoVendedor tipoVendedor = TipoVendedor.values()[menuVendedor - 1];
							PersistenciaVendedor persistenciaVendedor = tipoVendedor.getPersistenciaVendedor();
							persistenciaVendedor.persistencia(entrada, servicoVendedor);
						}
					} while (menuVendedor >= 1 && menuVendedor <= 6);
					System.out.println("\nSaindo do Menu Crud de Vendedor");
					break;

				default:
					break;
				}
			} while (escolhaMenu == 1 || escolhaMenu == 2);
			System.out.println("\nSaindo do Menu Crud da Aplicação!\nAté Mais");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
