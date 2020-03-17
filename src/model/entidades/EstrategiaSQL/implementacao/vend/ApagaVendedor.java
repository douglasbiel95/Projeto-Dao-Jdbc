package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.Scanner;

import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class ApagaVendedor implements PersistenciaVendedor{

	/* Classe que cont�m a chamada do m�todo que apaga um vendedor pelo id */
	
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		System.out.print("Informe o Id para apagar: ");
		int idVendedor = entrada.nextInt();
		servicoVendedor.deleteById(idVendedor);
		System.out.println("\nOpera��o realizada com sucesso!\n");
		
	}

	
	
	
}
