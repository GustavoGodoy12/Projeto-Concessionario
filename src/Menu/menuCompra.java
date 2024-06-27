package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Carro.carro;
import Operacoes.arquivoManipula;
import Operacoes.procura;
import Usuarios.funcionario;

public class menuCompra {
	
	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	menuProcuraCarro procuraCarro = new menuProcuraCarro();
	procura procura = new procura();
	arquivoManipula arq = new arquivoManipula();
	
	public void compraCarro(ArrayList<carro> carros, ArrayList<funcionario> funcionarios) {
		int id = 0;
		
		while(true) {
			System.out.println("===============================================================================");
			System.out.println("   ___       __  __     _ _                     ___                   _ \r\n"
					+ "  / _ \\ ___ |  \\/  |___| | |_  ___ _ _ ___ ___ | _ \\_ _ ___ __ ___ __| |\r\n"
					+ " | (_) (_-< | |\\/| / -_) | ' \\/ _ \\ '_/ -_|_-< |  _/ '_/ -_) _/ _ (_-<_|\r\n"
					+ "  \\___//__/ |_|  |_\\___|_|_||_\\___/_| \\___/__/ |_| |_| \\___\\__\\___/__(_)\r\n"
					+ "                                                            )_)         ");
			System.out.println("===============================================================================");
			System.out.println("___________________________________________________________________________________");
			System.out.println("| DIGITE O ID DO CARRO, CASO NÃO SAIBA - PROCURE-O NA OPÇÂO 'PROCURAR CARRO' E AD-|");
			System.out.println("| QUIRA O SEU CARRO DOS SONHOS HOJE PELO MELHOR PREÇO NO MERCADO!!                |");
			System.out.println("|                              [DIGITA 0 PARA VOLTAR]                             |");
			System.out.println("|_________________________________________________________________________________|");
			id = scannerNum.nextInt();
			if(id == 0) {
				break;
			}else if(id > carros.size() || id < 0) {
				System.out.println("id nao valido!");
			}else {
				System.out.println("_____________________________________");
		        System.out.println("ID:            " + carros.get(id).getIdCarro());
		        System.out.println("MARCA:         " + carros.get(id).getMarca());//id e posicao do indice
		        System.out.println("MODELO:        " + carros.get(id).getModelo());
		        System.out.println("-Usa " + carros.get(id).getTipoCombustivel());
		        System.out.println("PLACA:         " + carros.get(id).getPlaca());
		        System.out.println("ANO:           " + carros.get(id).getAno());
		        System.out.println("QUILOMETRAGEM: " + carros.get(id).getQuilometragem() + " km ");
		        System.out.println("PREÇO:         R$" + carros.get(id).getPreco());
		        System.out.println("_____________________________________");
		        System.out.println("|  ESSE É O CARRO QUE VOCÊ DESEJA?  |");
		        System.out.println("|___________________________________|");
		        System.out.println("| 1.SIM			 | 2.NÃO			|");
		        System.out.println("|________________|__________________|");
		        int op = scannerNum.nextInt();
		        if(op == 1){
		        	break;
		        }
			}
			
		}
		
		if(id > 0) {	
			while(true) {
				System.out.println("    /$$       /$$       /$$       /$$       /$$       /$$       /$$   \r\n"
						+ "  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$ \r\n"
						+ " /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$__  $$\r\n"
						+ "| $$  \\__/| $$  \\__/| $$  \\__/| $$  \\__/| $$  \\__/| $$  \\__/| $$  \\__/\r\n"
						+ "|  $$$$$$ |  $$$$$$ |  $$$$$$ |  $$$$$$ |  $$$$$$ |  $$$$$$ |  $$$$$$ \r\n"
						+ " \\____  $$ \\____  $$ \\____  $$ \\____  $$ \\____  $$ \\____  $$ \\____  $$\r\n"
						+ " /$$  \\ $$ /$$  \\ $$ /$$  \\ $$ /$$  \\ $$ /$$  \\ $$ /$$  \\ $$ /$$  \\ $$\r\n"
						+ "|  $$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/\r\n"
						+ " \\_  $$_/  \\_  $$_/  \\_  $$_/  \\_  $$_/  \\_  $$_/  \\_  $$_/  \\_  $$_/ \r\n"
						+ "   \\__/      \\__/      \\__/      \\__/      \\__/      \\__/      \\__/   \r\n"
						+ "                                                                      ");
				System.out.println("________________________________________________________________________________");
		        System.out.println("|           1. A VISTA                    ||       2. PARCELAS                 |");
		        System.out.println("|_________________________________________||___________________________________|");
		        System.out.println("|           0. SAIR                       ||                                   |");
		        System.out.println("|_________________________________________||___________________________________|");
				int opt = scannerNum.nextInt();
				if(opt > 2 || opt < 0) {
					System.out.println("Opcao invalida!");
				}else if(opt == 0) {
					break;
				}
				if(opt == 1) {
					comprarVista(carros, id);
					funcRelizarVenda(carros, id, funcionarios);
					break;
				}
				if(opt == 2) {
					parcelar(carros, id);
					funcRelizarVenda(carros, id, funcionarios);
					break;
				}
			}
		}
	}
	
	private void comprarVista(ArrayList<carro> carros, int id) {
		
		System.out.println("________________________________________________________________________________");
        System.out.println("| COMPRA APROVADA A VISTA!");
        System.out.println("| PAGAMENTO: R$" + carros.get(id).getPreco());
        System.out.println("|______________________________________________________________________________|");
		
	}
	
	private void parcelar(ArrayList<carro> carros, int id) {
		
		float juros = 0.0f;
		int parcelaQuantidade;
		
		while(true) {
			
			System.out.println("________________________________________________");
	        System.out.println("|   DIGITE A QUANTIDADE DE PARCELAS DESEJADA   |");
	        System.out.println("|            (MAXIMO DE 48 PARCELAS)           |");
	        System.out.println("|______________________________________________|");
	        parcelaQuantidade = scannerNum.nextInt();
	        
	        if(parcelaQuantidade <= 0 || parcelaQuantidade > 48) {
	        	System.out.println("Quantidade invalida.. Limite de 48 parcelas.");
	        }else {
	        	break;
	        }
	        
		}
		
		if(parcelaQuantidade > 3) {
			juros = (parcelaQuantidade * 2 )/ 10;
			System.out.println("APROVADO COM " + juros + "% DE JUROS!");
		}else {
			System.out.println("APROVADO SEM JUROS!");
		}
		
		double pagamento = (carros.get(id).getPreco() * juros) / parcelaQuantidade;
		
		
		System.out.println("________________________________________________________________________________");
        System.out.println("| COMPRA APROVADA:  " + parcelaQuantidade + "x PAGAMENTOS");
        System.out.println("| JUROS: " + juros + "%");
        System.out.println("| PAGAMENTO POR PARCELA:  R$" + pagamento);
        System.out.println("|______________________________________________________________________________|");
        
		
	}
	
	private void funcRelizarVenda(ArrayList<carro> carros, int id,ArrayList<funcionario> funcionarios) {
		int idFunc = 0;
		while(true) {
			String prefixoFunc = "func.";
			System.out.println("________________________________________________");
	        System.out.println("|   DIGITE O NOME DO FUNCIONARIO QUE AUXILOU/  |");
	        System.out.println("|                REALIZOU A COMPRA.            |");
	        System.out.println("|______________________________________________|");
	        String nomeFunc = scannerString.nextLine();
	        if(!nomeFunc.startsWith("func.")) {
	        	nomeFunc = prefixoFunc + nomeFunc;
	        }
	        boolean existe = procura.confirmaFuncionarioUsername(nomeFunc, funcionarios);
	        if(existe) {
	        	idFunc = procura.procuraPorNomeFuncionario(nomeFunc, funcionarios);
	        	System.out.println(idFunc);
	        	break;
	        }else {
	        	System.out.println("funcionario nao existe, por favor digite o nome do funcionario.");
	        }
		}
		// mal feito eu sei, mas funciona e foi passado em aula
		double valorNovaVenda = carros.get(id).getPreco();
		System.out.println(valorNovaVenda);
		for(funcionario funcionario : funcionarios) {
			if(funcionario.getIdUsuario() == idFunc) {
				funcionario.realizarVenda(1);
				funcionario.adicionarTotalValorVenda(valorNovaVenda);
			}
		}
		arq.registrafuncionario(funcionarios);
        System.out.println("Obrigado!");
	}

}
