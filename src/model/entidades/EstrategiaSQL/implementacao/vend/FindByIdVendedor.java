package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.Scanner;

import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class FindByIdVendedor implements PersistenciaVendedor {

	/* Classe que cont�m uma chamada ao m�todo que procura um vendedor pelo Id */
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		System.out.print("Informe o Id do Vendedor: ");
		int idVendedor = entrada.nextInt();
		
		Vendedor vendedor = servicoVendedor.findById(idVendedor);
		System.out.println(vendedor);
		System.out.println("\nOpera��o realizada! Vendedor encontrado!\n");
		
	}

}
