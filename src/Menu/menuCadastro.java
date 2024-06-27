package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Operacoes.arquivoManipula;
import Operacoes.procura;
import Usuarios.cliente;

public class menuCadastro {

	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	procura procura = new procura();
	arquivoManipula arq = new arquivoManipula();
	
	public void cadastroCliente(ArrayList<cliente> clientes) {
		
		while(true) {
			
			System.out.println("_____________________________________________");
			System.out.println("| DIGITE O SEU NOME DE USUARIO:            ||");
			System.out.println("|__________________________________________||");
			String username = scannerString.nextLine();
			System.out.println("_____________________________________________");
			System.out.println("| DIGITE A SUA SENHA:                      ||");
			System.out.println("|__________________________________________||");
			String password = scannerString.nextLine();
			
			boolean confirma = procura.confirma(password, username, clientes);
			if(confirma) {
				System.out.println("Nome de usuario ja existe, escolha outro por favor.");
			}else {
				int idUser;
				if(clientes.size() == 0) {
					idUser =1 ;
				}else {
					idUser = clientes.size();
				}
				cliente clienteNovo = new cliente(idUser, username, password);
				clientes.add(clienteNovo);
				arq.registraClientes(clientes);
				System.out.println("Cadastrado com sucesso!");
				break;
			}
			
		}
		
	}
	
}
