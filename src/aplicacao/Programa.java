package aplicacao;

import java.text.ParseException;
import java.util.Scanner;

import model.entidades.EstrategiaSQL.PersistenciaDepartamento;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import model.entidades.enums.TipoDepartamento;
import model.entidades.enums.TipoVendedor;
import servico.ServicoVendedor;
import servico.ServicoDepartamento;

public class Programa {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub

		ServicoVendedor servicoVendedor = new ServicoVendedor();
		ServicoDepartamento servicoDepartamento = new ServicoDepartamento();
		
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
				case 2:
					int menuDepartamento;
					/* Menu Crud Departamento */
					do {
						ExibeMenus.exibeOpCrudDepartamento();
						menuDepartamento = entrada.nextInt();
						entrada.nextLine();
						
						if (menuDepartamento <= TipoDepartamento.values().length) {
							TipoDepartamento td = TipoDepartamento.values()[menuDepartamento - 1];
							PersistenciaDepartamento pd = td.getPersistenciaDepartamento();
							pd.persistencia(entrada, servicoDepartamento);
						}
						
					} while (menuDepartamento >= 1 && menuDepartamento <= 5);
					break;
				}
			} while (escolhaMenu == 1 || escolhaMenu == 2);
			System.out.println("\nSaindo do Menu Crud da Aplicação!\nAté Mais");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
