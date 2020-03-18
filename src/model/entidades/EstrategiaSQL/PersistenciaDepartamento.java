package model.entidades.EstrategiaSQL;

import java.util.Scanner;

import servico.ServicoDepartamento;


public interface PersistenciaDepartamento {

	public void persistencia(Scanner entrada, ServicoDepartamento servicoDepartamento);
	
}
