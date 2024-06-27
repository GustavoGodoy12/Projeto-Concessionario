package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Carro.carro;
import Operacoes.operacoesFuncionarios;
import Usuarios.cliente;
import Usuarios.funcionario;

public class menuPrincipal {

	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	menuProcuraCarro procuraCarro = new menuProcuraCarro();
	menuCompra menuCompra = new menuCompra();
	operacoesFuncionarios operacoesFunc = new operacoesFuncionarios();
	
	public int menuPrincipal(int idUserLogged, int opt, ArrayList<carro> carros, ArrayList<funcionario> funcionarios, ArrayList<cliente> clientes) {
		
		while(true) {
			System.out.println("===============================================================================");
			System.out.println("  __  __ ___ _  _ _   _            ___ ___ ___ _  _  ___ ___ ___  _   _    \r\n"
					+ " |  \\/  | __| \\| | | | |          | _ \\ _ \\_ _| \\| |/ __|_ _| _ \\/_\\ | |   \r\n"
					+ " | |\\/| | _|| .` | |_| |          |  _/   /| || .` | (__ | ||  _/ _ \\| |__ \r\n"
					+ " |_|  |_|___|_|\\_|\\___/           |_| |_|_\\___|_|\\_|\\___|___|_|/_/ \\_\\____|\r\n"
					+ "                                                                           ");
			System.out.println("===============================================================================");
			System.out.println("________________________________________________________________________________");
	        System.out.println("|           1. COMPRAR UM CARRO           ||       2. PESQUISAR UM CARRO       |");
	        System.out.println("|_________________________________________||___________________________________|");
	        if(idUserLogged >= 10000) { // id funcionarios comecam a partir do 10000
	        System.out.println("|           3. ADICIONAR UM FUNCIONARIO   ||       4. APAGAR UM CADASTRO       |");
	        System.out.println("|_________________________________________||___________________________________|");
	        System.out.println("|           5. RELATORIO                  ||       0. SAIR                     |");
	        System.out.println("|_________________________________________||___________________________________|");
	        
	        }else {
	        	System.out.println("|           0. SAIR                       ||                                   |");
		        System.out.println("|_________________________________________||___________________________________|");
	        }
			opt = scannerNum.nextInt();
			if(opt == 0) {
				return opt = -1;
			}
			
			if((opt > 2 || opt < 0 ) && idUserLogged < 10000){
				System.out.println("Opcao invalida");
			}
			
			if(opt == 1) {
				menuCompra.compraCarro(carros, funcionarios);
			}
			if(opt == 2) {
				procuraCarro.procuraCarro(carros);
			}
			
			if(idUserLogged >= 10000) {
				
				if(opt == 3) {
					operacoesFunc.cadastrarFuncionario(funcionarios);
				}
				
				if(opt == 4) {
					operacoesFunc.apagarCadastro(funcionarios, carros, clientes);
				}
				
				if(opt == 5) {
					operacoesFunc.gerarRelatorio(funcionarios, clientes, carros);
				}
				
			}
			
		}
		
	}
	
	
}
