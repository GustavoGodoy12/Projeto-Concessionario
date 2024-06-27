package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Carro.carro;
import Operacoes.procura;

public class menuProcuraCarro {
	
	Scanner scannerNum = new Scanner(System.in);
	Scanner scannerString = new Scanner(System.in);
	procura procura = new procura();
	
	void procuraCarro(ArrayList<carro> carros) {
		
		while(true) {
			
			System.out.println("  ___          _ _                 _            ___           _           \r\n"
					+ " | _ \\___ __ _| (_)_____ _ _ _  __| |___       / __| ___ _ _ | |_  ___ ___\r\n"
					+ " |   / -_) _` | | |_ / _` | ' \\/ _` / _ \\      \\__ \\/ _ \\ ' \\| ' \\/ _ (_-<\r\n"
					+ " |_|_\\___\\__,_|_|_/__\\__,_|_||_\\__,_\\___/      |___/\\___/_||_|_||_\\___/__/\r\n"
					+ "                                                                          ");
			System.out.println("___________________________________________________________________________________");
	        System.out.println("|          1. PROCURAR POR MARCA          ||          2. PROCURAR POR PREÇO       |");
	        System.out.println("|_________________________________________||______________________________________|");
	        System.out.println("|          3. PROCURAR POR MODELO         ||          4. PROCURAR POR ANO         |");
	        System.out.println("|_________________________________________||______________________________________|");
	        System.out.println("|          0. VOLTAR                      ||                                      |");
	        System.out.println("|_________________________________________||______________________________________|");
	        int op = scannerNum.nextInt();
			if(op > 4 || op < 0) {
				System.out.println("opcao invalida");
			}else if(op == 0) {
				break;
			}
			if(op == 1) {
				procuraPorMarca(carros);
			}
			if(op == 2) {
				procuraPreco(carros);
			}
			if(op == 3) {
				procuraPorModelo(carros);
			}
			if(op == 4) {
				procuraPorAno(carros);
			}
		}
		
	}
	
	private void procuraPorMarca(ArrayList<carro> carros) {
		
		ArrayList<Integer> carrosProcura = new ArrayList<>(); 
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           DIGITE O NOME DA MARCA DO CARRO.                      |");
		System.out.println("|_________________________________________________________________________________|");
		String marca = scannerString.nextLine();
		
		carrosProcura = procura.procuraPorMarca(marca, carros, carrosProcura);
		
		listagem(carros, carrosProcura);
		
	}
	
	private void procuraPreco(ArrayList<carro> carros) {
		
		ArrayList<Integer> carrosProcura = new ArrayList<>(); 
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           DIGITE O PRECO MAXIMO DO CARRO.                       |");
		System.out.println("|_________________________________________________________________________________|");
		double precoMax = scannerNum.nextDouble();
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           DIGITE O PRECO MINIMO DO CARRO.                       |");
		System.out.println("|_________________________________________________________________________________|");
		double precoMin = scannerNum.nextDouble();
		
		carrosProcura = procura.procuraPorPreco(precoMin, precoMax, carros, carrosProcura);
		
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           CARROS DENTRO DA FAIXA DE PRECO:                      |");
		System.out.println("|_________________________________________________________________________________|");
		
		listagem(carros, carrosProcura);
		
	}
	
	private void procuraPorModelo(ArrayList<carro> carros) {
		
		ArrayList<Integer> carrosProcura = new ArrayList<>(); 
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           DIGITE O NOME DO MODELO DO CARRO.                     |");
		System.out.println("|_________________________________________________________________________________|");
		String modelo = scannerString.nextLine();
		
		carrosProcura = procura.procuraPorModelo(modelo, carros, carrosProcura);
		
		listagem(carros, carrosProcura);
		
	}
	
	private void procuraPorAno(ArrayList<carro> carros) {
		
		ArrayList<Integer> carrosProcura = new ArrayList<>(); 
		System.out.println("___________________________________________________________________________________");
		System.out.println("|                           DIGITE O ANO DO CARRO.                                |");
		System.out.println("|_________________________________________________________________________________|");
		int ano = scannerNum.nextInt();
		
		carrosProcura = procura.procuraPorAno(ano, carros, carrosProcura);
		
		listagem(carros, carrosProcura);
		
	}
	
	private void listagem(ArrayList<carro> carros, ArrayList<Integer> carrosProcura) {
		
		if(carrosProcura.size() > 0) {
			for (int i = 0; i < carrosProcura.size(); i++) {
			    int carroId = carrosProcura.get(i);
			    carro carroEncontrado = null;
	
			    for (carro carro : carros) {
			        if (carro.getIdCarro() == carroId) {
			            carroEncontrado = carro;
			            break;
			        }
			    }
	
			    if (carroEncontrado != null) {
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
		}else {
			System.out.println("Nenhum carro encontrado ...");
		}
		
	}

}
