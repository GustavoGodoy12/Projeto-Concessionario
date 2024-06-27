package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Operacoes.procura;
import Usuarios.cliente;
import Usuarios.funcionario;

public class menuLogin {
	
	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	procura procura = new procura();
	
	public int menuLogin(int op, int idUserLogged, ArrayList<cliente> clientes, ArrayList<funcionario> funcionarios) {
		
		while(true) {
			System.out.println("_____________________________________________");
			System.out.println("| DIGITE O SEU NOME DE USUARIO:            ||");
			System.out.println("|__________________________________________||");
			String username = scannerString.nextLine();
			System.out.println("_____________________________________________");
			System.out.println("| DIGITE A SUA SENHA:                      ||");
			System.out.println("|__________________________________________||");
			String password = scannerString.nextLine();
			
			if(username.startsWith("func.")) { //todo username de funcionario comeca com func.
				
				boolean confirma = procura.confirmaFuncionario(password, username, funcionarios);
				if(confirma) {
					idUserLogged = procura.procuraPorNomeFuncionario(username, funcionarios);
					break;
				}else {
					System.out.println("Funcionario nao encontrado- tente novamente! \nDigite 1 para tentar ou digite 0 para sair");
					op = scannerNum.nextInt();
					if(op == 0) {
						break;
					}
				}
				
				
			}else {
				boolean confirmado = procura.confirma(password, username, clientes);
				if(confirmado) {
					idUserLogged = procura.procuraPorNome(username, clientes);
					break;
				}else {
					System.out.println("Usuario nao encontrado- tente novamente! \nDigite 1 para tentar ou digite 0 para sair");
					op = scannerNum.nextInt();
					if(op == 0) {
						break;
					}
				}
			}
			
			
			
		}
		
		return idUserLogged;
	}

}
