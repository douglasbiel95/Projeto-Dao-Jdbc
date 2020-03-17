package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.Scanner;

import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class ApagaVendedor implements PersistenciaVendedor{

	/* Classe que contém a chamada do método que apaga um vendedor pelo id */
	
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		System.out.print("Informe o Id para apagar: ");
		int idVendedor = entrada.nextInt();
		servicoVendedor.deleteById(idVendedor);
		System.out.println("\nOperação realizada com sucesso!\n");
		
	}

	
	
	
}
