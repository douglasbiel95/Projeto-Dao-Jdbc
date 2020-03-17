package model.entidades.EstrategiaSQL;

import java.util.Scanner;

import servico.ServicoVendedor;

public interface PersistenciaVendedor {

	public void persistencia(Scanner entrada, ServicoVendedor servicoVendedor);
	
}
