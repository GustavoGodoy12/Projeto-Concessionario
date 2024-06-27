package Operacoes;

import java.util.ArrayList;
import java.util.Scanner;

import Carro.carro;
import Usuarios.cliente;
import Usuarios.funcionario;

public class operacoesFuncionarios {
	
	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	procura procura = new procura();
	arquivoManipula arq = new arquivoManipula();
	
	public ArrayList<funcionario> cadastrarFuncionario(ArrayList<funcionario> funcionarios) {
		
		String prefixoFuncionario = "func.";
		
		while(true) {
			System.out.println("______________________________________________________");
			System.out.println("| DIGITE O SEU NOME DO NOVO FUNCIONARIO:            ||");
			System.out.println("|___________________________________________________||");
			String username = scannerString.nextLine();
			username = prefixoFuncionario + username;
			System.out.println("______________________________________________________");
			System.out.println("| DIGITE A SENHA DO NOVO FUNCIONARIO:               ||");
			System.out.println("|___________________________________________________||");
			String password = scannerString.nextLine();
			System.out.println("______________________________________________________");
			System.out.println("| DIGITE O CARGO DO NOVO FUNCIONARIO:               ||");
			System.out.println("|___________________________________________________||");
			String cargo = scannerString.nextLine();
			System.out.println("______________________________________________________");
			System.out.println("| DIGITE O HORARIO DO NOVO FUNCIONARIO:             ||");
			System.out.println("| EXEMPLO: 8 Horas das 7:00 as 15:00 de segunda a   ||");
			System.out.println("| sexta.                                            ||");
			System.out.println("|___________________________________________________||");
			String horario = scannerString.nextLine();
			int totalVendas = 0;
			
			boolean confirma = procura.confirmaFuncionario(horario, horario, funcionarios);
			if(confirma) {
				System.out.println("Nome de usuario ja existe, escolha outro por favor.");
			}else {
				int idUser;
				if(funcionarios.size() == 0) {
					idUser = 10000 ;
				}else {
					idUser = funcionarios.size() + 10000;
				}
				double totalValorVendas = 0.0;
				funcionario funcionarioNovo = new funcionario(idUser, username, password, cargo, horario, totalVendas, totalValorVendas);
				funcionarios.add(funcionarioNovo);
				arq.registrafuncionario(funcionarios);
				System.out.println("Cadastrado com sucesso!");
				return funcionarios;
			}
		}
	}
	
	public void apagarCadastro(ArrayList<funcionario> funcionarios, ArrayList<carro> carros, ArrayList<cliente> clientes) {
		
		while(true) {
			System.out.println("    _                                         _         _                __  __              \r\n"
					+ "   /_\\  _ __  __ _ __ _ __ _ _ _   __ __ _ __| |__ _ __| |_ _ _ ___ ___ |  \\/  |___ _ _ _  _ \r\n"
					+ "  / _ \\| '_ \\/ _` / _` / _` | '_| / _/ _` / _` / _` (_-<  _| '_/ _ (_-< | |\\/| / -_) ' \\ || |\r\n"
					+ " /_/ \\_\\ .__/\\__,_\\__, \\__,_|_|   \\__\\__,_\\__,_\\__,_/__/\\__|_| \\___/__/ |_|  |_\\___|_||_\\_,_|\r\n"
					+ "       |_|        |___/                                                                      ");
			System.out.println("______________________________________________________________________________");
	        System.out.println("|         1. APAGAR UM CADASTRO         ||       2. APAGAR UM CADASTRO       |");
	        System.out.println("|               DE CLIENTE              ||            DE FUNCIONARIO         |");
	        System.out.println("|_______________________________________||___________________________________|");
	        System.out.println("|         3. APAGAR UM CADASTRO         ||              0. SAIR              |");
	        System.out.println("|                DE CARRO               ||                                   |");
	        System.out.println("|_______________________________________||___________________________________|");
	        int op = scannerNum.nextInt();
	        if(op > 4 || op < 0) {
	        	System.out.println("opcao invalida!");
	        }else if(op == 0) {
	        	break;
	        }
	        
	        if(op == 1) {
	        	apagarCliente(clientes);
	        	arq.registraClientes(clientes);
	        }
	        
	        if(op == 2) {
	        	apagarFuncionario(funcionarios);
	        	arq.registrafuncionario(funcionarios);
	        }
	        
	        if(op == 3) {
	        	apagarCarro(carros);
	        	arq.registraCarro(carros);
	        }
	        
		}
			
	}
	
private ArrayList<carro> apagarCarro(ArrayList<carro> carros) {
		
		while(true) {
			System.out.println("    _                               ___         _         _                _        ___                     \r\n"
					+ "   /_\\  _ __  __ _ __ _ __ _ _ _   / __|__ _ __| |__ _ __| |_ _ _ ___   __| |___   / __|__ _ _ _ _ _ ___ ___\r\n"
					+ "  / _ \\| '_ \\/ _` / _` / _` | '_| | (__/ _` / _` / _` (_-<  _| '_/ _ \\ / _` / -_) | (__/ _` | '_| '_/ _ (_-<\r\n"
					+ " /_/ \\_\\ .__/\\__,_\\__, \\__,_|_|    \\___\\__,_\\__,_\\__,_/__/\\__|_| \\___/ \\__,_\\___|  \\___\\__,_|_| |_| \\___/__/\r\n"
					+ "       |_|        |___/                                                                                     ");
			System.out.println("______________________________________________________________________________");
			System.out.println("| CASO NAO SAIBA O ID DO CARRO, VEJA A OPCAO DE PROCURA NO MENU PRINCICPAL. ||");
			System.out.println("|___________________________________________________________________________||");
			System.out.println("______________________________________________________________________________");
	        System.out.println("|          1. LISTAR CARROS             ||       2. APAGAR POR ID            |");
	        System.out.println("|_______________________________________||___________________________________|");
	        System.out.println("|          0. SAIR                      ||                                   |");
	        System.out.println("|_______________________________________||___________________________________|");
	        int op = scannerNum.nextInt();
	        if(op > 2 || op < 0) {
	        	System.out.println("opcao invalida!");
	        }else if(op == 0) {
	        	break;
	        }
	        
	        if(op == 1) {
	        	listarCarros(carros);
	        }
	        
	        if(op == 2) {
	        	apagarCarroId(carros);
	        	break;
	        }
	        
		}
		return carros;
	}
	
private void apagarCarroId(ArrayList<carro> carros) {
		
		System.out.println("______________________________________________________");
		System.out.println("| DIGITE O ID PARA DELETA-LO:                       ||");
		System.out.println("|___________________________________________________||");
		int id = scannerNum.nextInt();
		System.out.println("Certeza que quer deletar permanentemente o carro? \n1. SIM  || 2.NAO");
		int op = scannerNum.nextInt();
		if(op == 1) {
			carros.remove(id);
		}
		System.out.println("cadastro de carro deletado com sucesso!");
	}
	
private void listarCarros(ArrayList<carro> carros) {
		
		for(carro carroEncontrado : carros) {
			System.out.println("____________________________________");
	        System.out.println("ID:            " + carroEncontrado.getIdCarro());
	        System.out.println("MARCA:         " + carroEncontrado.getMarca());
	        System.out.println("MODELO:        " + carroEncontrado.getModelo());
	        System.out.println("-Usa " + carroEncontrado.getTipoCombustivel());
	        System.out.println("PLACA:         " + carroEncontrado.getPlaca());
	        System.out.println("ANO:           " + carroEncontrado.getAno());
	        System.out.println("QUILOMETRAGEM: " + carroEncontrado.getQuilometragem() + " km ");
	        System.out.println("PREÇO:         R$" + carroEncontrado.getPreco());
	        System.out.println("____________________________________");
		}
		
	}
	
	private ArrayList<funcionario> apagarFuncionario(ArrayList<funcionario> funcionarios) {
		
		while(true) {
			System.out.println("    _                               ___         _         _                _       ___             _                   _     \r\n"
					+ "   /_\\  _ __  __ _ __ _ __ _ _ _   / __|__ _ __| |__ _ __| |_ _ _ ___   __| |___  | __|  _ _ _  __(_)___ _ _  __ _ _ _(_)___ \r\n"
					+ "  / _ \\| '_ \\/ _` / _` / _` | '_| | (__/ _` / _` / _` (_-<  _| '_/ _ \\ / _` / -_) | _| || | ' \\/ _| / _ \\ ' \\/ _` | '_| / _ \\\r\n"
					+ " /_/ \\_\\ .__/\\__,_\\__, \\__,_|_|    \\___\\__,_\\__,_\\__,_/__/\\__|_| \\___/ \\__,_\\___| |_| \\_,_|_||_\\__|_\\___/_||_\\__,_|_| |_\\___/\r\n"
					+ "       |_|        |___/                                                                                                      ");
			System.out.println("______________________________________________________________________________");
	        System.out.println("|          1. LISTAR FUNCIONARIOS       ||       2. APAGAR POR USERNAME      |");
	        System.out.println("|_______________________________________||___________________________________|");
	        System.out.println("|          3. APAGAR POR ID             ||       0. SAIR                     |");
	        System.out.println("|_______________________________________||___________________________________|");
	        int op = scannerNum.nextInt();
	        if(op > 4 || op < 0) {
	        	System.out.println("opcao invalida!");
	        }else if(op == 0) {
	        	break;
	        }
	        
	        if(op == 1) {
	        	listarFuncionarios(funcionarios);
	        }
	        
	        if(op == 2) {
	        	apagarFuncionarioUsername(funcionarios);
	        	 break;
	        }
	        
	        if(op == 3) {
	        	apagarFuncionarioId(funcionarios);
	        	 break;
	        }
	        
		}
		return funcionarios;
	}
	
	private void apagarFuncionarioId(ArrayList<funcionario> funcionarios) {
		
		System.out.println("______________________________________________________");
		System.out.println("| DIGITE O ID PARA DELETA-LO:                       ||");
		System.out.println("|___________________________________________________||");
		int id = scannerNum.nextInt();
		System.out.println("Certeza que quer deletar permanentemente o usuario? \n1. SIM  || 2.NAO");
		int op = scannerNum.nextInt();
		if(op == 1) {
			funcionarios.remove(id);
		}
		System.out.println("usuario deletado com sucesso!");
	}
	
	private void apagarFuncionarioUsername(ArrayList<funcionario> funcionarios) {
		
		System.out.println("____________________________________________________________");
		System.out.println("| DIGITE O USERNAME DO FUNCIONARIO PARA DELETA-LO:        ||");
		System.out.println("|_________________________________________________________||");
		String username = scannerString.nextLine();
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getUsername().equalsIgnoreCase(username)) {
				System.out.println("Certeza que quer deletar permanentemente o funcionario? \n1. SIM  || 2.NAO");
				int op = scannerNum.nextInt();
				if(op == 1) {
					funcionarios.remove(i);
				}
			}
		}
		System.out.println("usuario deletado com sucesso!");
	}
	
	private void listarFuncionarios(ArrayList<funcionario> funcionarios) {
		
		for(funcionario funcionario : funcionarios) {
			System.out.println("________________________");
			System.out.println("id: " + funcionario.getIdUsuario());
			System.out.println("Username:" + funcionario.getUsername());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Horario: " + funcionario.getHorario());
			System.out.println("Total de Vendas: " + funcionario.getTotalVendas());
			System.out.println("Valor Total de Vendas: R$" +funcionario.getTotalValorVenda());
			System.out.println("________________________");
		}
		
	}
	
	private ArrayList<cliente> apagarCliente(ArrayList<cliente> clientes){
		
		while(true) {
			System.out.println("    _                               ___         _         _                _        ___ _ _         _       \r\n"
					+ "   /_\\  _ __  __ _ __ _ __ _ _ _   / __|__ _ __| |__ _ __| |_ _ _ ___   __| |___   / __| (_)___ _ _| |_ ___ \r\n"
					+ "  / _ \\| '_ \\/ _` / _` / _` | '_| | (__/ _` / _` / _` (_-<  _| '_/ _ \\ / _` / -_) | (__| | / -_) ' \\  _/ -_)\r\n"
					+ " /_/ \\_\\ .__/\\__,_\\__, \\__,_|_|    \\___\\__,_\\__,_\\__,_/__/\\__|_| \\___/ \\__,_\\___|  \\___|_|_\\___|_||_\\__\\___|\r\n"
					+ "       |_|        |___/                                                                                     ");
			System.out.println("______________________________________________________________________________");
	        System.out.println("|          1. LISTAR CLIENTES           ||       2. APAGAR POR USERNAME      |");
	        System.out.println("|_______________________________________||___________________________________|");
	        System.out.println("|          3. APAGAR POR ID             ||       0. SAIR                     |");
	        System.out.println("|_______________________________________||___________________________________|");
	        int op = scannerNum.nextInt();
	        if(op > 4 || op < 0) {
	        	System.out.println("opcao invalida!");
	        }else if(op == 0) {
	        	break;
	        }
	        
	        if(op == 1) {
	        	listarClientes(clientes);
	        }
	        
	        if(op == 2) {
	        	apagarClienteUsername(clientes);
	        	break;
	        }
	        
	        if(op == 3) {
	        	apagarClienteId(clientes);
	        	break;
	        }
	        
		}
		return clientes;
	}
	
	private void apagarClienteId(ArrayList<cliente> clientes) {
		
		System.out.println("______________________________________________________");
		System.out.println("| DIGITE O ID PARA DELETA-LO:                       ||");
		System.out.println("|___________________________________________________||");
		int id = scannerNum.nextInt();
		System.out.println("Certeza que quer deletar permanentemente o usuario? \n1. SIM  || 2.NAO");
		int op = scannerNum.nextInt();
		if(op == 1) {
			clientes.remove(id);
		}
		System.out.println("usuario deletado com sucesso!");
	}
	
	private void apagarClienteUsername(ArrayList<cliente> clientes) {
		
		System.out.println("______________________________________________________");
		System.out.println("| DIGITE O USERNAME DO USUARIO PARA DELETA-LO:      ||");
		System.out.println("|___________________________________________________||");
		String username = scannerString.nextLine();
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getUsername().equalsIgnoreCase(username)) {
				System.out.println("Certeza que quer deletar permanentemente o usuario? \n1. SIM  || 2.NAO");
				int op = scannerNum.nextInt();
				if(op == 1) {
					clientes.remove(i);
				}
			}
		}
		System.out.println("usuario deletado com sucesso!");
	}
	
	private void listarClientes(ArrayList<cliente> clientes) {
		
		for(cliente cliente : clientes) {
			System.out.println("________________________");
			System.out.println("id: " + cliente.getIdUsuario());
			System.out.println("Username:" + cliente.getUsername());
			System.out.println("________________________");
		}
		
	}
	
	public void gerarRelatorio(ArrayList<funcionario> funcionarios, ArrayList<cliente> clientes, ArrayList<carro> carros) {
		
		while(true) {
			System.out.println("  ___     _      _           _        \r\n"
					+ " | _ \\___| |__ _| |_ ___ _ _(_)___ ___\r\n"
					+ " |   / -_) / _` |  _/ _ \\ '_| / _ (_-<\r\n"
					+ " |_|_\\___|_\\__,_|\\__\\___/_| |_\\___/__/\r\n"
					+ "                                      ");
			System.out.println("______________________________________________________________________________");
	        System.out.println("|         1. GERAR RELATORIO DE         ||       2. GERAR RELATORIO DE       |");
	        System.out.println("|       UM FUNCIONARIO ESPECIFICO       ||         TODOS FUNCIONARIOS        |");
	        System.out.println("|_______________________________________||___________________________________|");
	        System.out.println("|         3. GERAR RELATORIO DA         ||              0. SAIR              |");
	        System.out.println("|             CONCESSIONARIA            ||                                   |");
	        System.out.println("|_______________________________________||___________________________________|");
	        int op = scannerNum.nextInt();
	        if(op > 3 || op < 0) {
	        	System.out.println("opcao invalida!");
	        }else if(op == 0) {
	        	break;
	        }
	        
	        if(op == 1) {
	        	gerarRelatorioFuncionario(funcionarios);
	        }
	        
	        if(op == 2) {
	        	listarFuncionarios(funcionarios);
	        }
	        
	        if(op == 3) {
	        	gerarRelatorioGeral(funcionarios, clientes, carros);
	        }
	        
		}
			
	}

	private void gerarRelatorioGeral(ArrayList<funcionario> funcionarios, ArrayList<cliente> clientes, ArrayList<carro> carros) {
		
		double valorTotalVendas = 0;
		int vendasTotais = 0;
		for(funcionario funcionario : funcionarios) {
			vendasTotais += funcionario.getTotalVendas();
			valorTotalVendas += funcionario.getTotalValorVenda();
		}
		double valorTotalCarros = 0;
		double mediaAno = 0;
		for(carro carro : carros) {
			valorTotalCarros+= carro.getPreco();
			mediaAno += carro.getAno();
			
		}
		mediaAno = mediaAno / carros.size();
		double mediaValorCarros = valorTotalCarros / carros.size();
		
		System.out.println("____________________________________________________");
		System.out.println("|_______________________");
		System.out.println("|TOTAL CADASTROS:");
		System.out.println("|Total de Clientes Cadastrados: " + clientes.size());
		System.out.println("|Total de Funcionarios Cadastrados:" + funcionarios.size());
		System.out.println("|Total de Carros Cadastrados: " + carros.size());
		System.out.println("|_______________________");
		System.out.println("|Vendas:");
		System.out.println("|________________________");
		System.out.println("|Total de Vendas: " + vendasTotais);
		System.out.println("|Valor Total de Vendas: R$" + valorTotalVendas);
		System.out.println("|_______________________");
		System.out.println("|Carros:");
		System.out.println("|________________________");
		System.out.println("|Valor Total dos Carros: R$" + valorTotalCarros);
		System.out.println("|Media do Valor dos Carros: R$" + mediaValorCarros);
		System.out.println("|Media do Ano dos Carros: " + mediaAno);
		System.out.println("|_______________________");
		System.out.println("|___________________________________________________");
		
	}
	private void gerarRelatorioFuncionario(ArrayList<funcionario> funcionarios) {
		
		int idFunc = 0;
		while(true) {
			String prefixoFunc = "func.";
			System.out.println("________________________________________________");
	        System.out.println("|         DIGITE O NOME DO FUNCIONARIO         |");
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
		for(funcionario funcionario : funcionarios ) {
			if(funcionario.getIdUsuario() == idFunc) {
				System.out.println("________________________");
				System.out.println("id: " + funcionario.getIdUsuario());
				System.out.println("Username:" + funcionario.getUsername());
				System.out.println("Cargo: " + funcionario.getCargo());
				System.out.println("Horario: " + funcionario.getHorario());
				System.out.println("Total de Vendas: " + funcionario.getTotalVendas());
				System.out.println("Valor Total de Vendas: R$" +funcionario.getTotalValorVenda());
				System.out.println("________________________");
			}
		}
	}

}
