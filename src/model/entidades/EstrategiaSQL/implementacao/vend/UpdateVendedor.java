package model.entidades.EstrategiaSQL.implementacao.vend;

import java.util.Scanner;

import model.entidades.Vendedor;
import model.entidades.EstrategiaSQL.PersistenciaVendedor;
import servico.ServicoVendedor;

public class UpdateVendedor implements PersistenciaVendedor {

	/* Classe que cont�m uma chamada ao m�todo que faz o update de um vendedor */
	
	@Override
	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor) {
		
		System.out.print("Informe o Id do Vendedor: ");
		Vendedor vendedor = servicoVendedor.findById(entrada.nextInt());
		entrada.nextLine();
		
		System.out.print("Informe o novo email do Vendedor: ");
		vendedor.setEmailVendendor(entrada.nextLine());
		
		System.out.print("Informe o novo sal�rio do Vendedor: ");
		vendedor.setSalarioBase(entrada.nextDouble());
		
		servicoVendedor.update(vendedor);
		System.out.println("\nOpera��o realizada! Informa��es foram atualizadas!\n");
	}

}
