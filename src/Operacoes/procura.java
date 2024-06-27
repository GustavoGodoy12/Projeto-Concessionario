package Operacoes;

import java.util.ArrayList;

import Carro.carro;
import Usuarios.cliente;
import Usuarios.funcionario;

public class procura {
	
	//	OPERACOES DE PROCURA CLIENTES
	
	//	procura por nome retorna o id
	
	public int	procuraPorNome(String username, ArrayList<cliente> clientes) {
		int k =0;
		for(int i = 0; i < clientes.size(); i++) {
			
			if(clientes.get(i).getUsername().equals(username)) {
				k = i;
			}
			
		}
		return clientes.get(k).getIdUsuario();
	}
	
	
	//	faz uma procura, se o cadastro exister volta true
	
	public Boolean confirma(String password, String username, ArrayList<cliente> clientes) {
		int k =0;
		for(int i = 0; i < clientes.size(); i++) {
			
			if(clientes.get(i).getUsername().equals(username) && clientes.get(i).getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
	}
	
	
	//	OPERACOES DE PROCURA DE CARROS
	
	//procura por placa, retorna o id do carro
	
	int procuraPlaca(String placa, ArrayList<carro> carros) {
		
		for(carro carro : carros) {
			if(carro.getPlaca() == placa) {
				return carro.getIdCarro();
			}
		}
		
		return 0;
	}
	
	//procura por marca, retorna um Array com o id dos carros com a marca;
	
	public ArrayList<Integer> procuraPorMarca(String marca, ArrayList<carro> carros, ArrayList<Integer> resultado){
		
		for(carro carro : carros) { //ele busca o carro dentro da classe carro
			if(carro.getMarca().equalsIgnoreCase(marca)) {
				resultado.add(carro.getIdCarro());
			}
		}
		return resultado;
	}
	
	//procura por modelo mesma coisa que so que tem de mudar o .get
	public ArrayList<Integer> procuraPorModelo(String modelo, ArrayList<carro> carros, ArrayList<Integer> resultado){
		
		for(carro carro : carros) {
			if(carro.getModelo().equalsIgnoreCase(modelo)) {
				resultado.add(carro.getIdCarro());
			}
		}
		return resultado;
	}
	
	//procura por ano
	public ArrayList<Integer> procuraPorAno(int ano, ArrayList<carro> carros, ArrayList<Integer> resultado){
		
		for(carro carro : carros) {
			if(carro.getAno() == ano) {
				resultado.add(carro.getIdCarro());
			}
		}
		return resultado;
	}
	
	//procura por faixa de preco, retorna um Array com os id dos carros que se encaixam na faixa
	
	public ArrayList<Integer> procuraPorPreco(double precoMin, double precoMax, ArrayList<carro> carros, ArrayList<Integer> resultado){
		
		for(int i = 1; i < carros.size(); i++) {
			
			if(carros.get(i).getPreco() >= precoMin) {
				if(precoMax >= carros.get(i).getPreco()) {
					resultado.add(carros.get(i).getIdCarro());
				}
			}
			
		}
		return resultado;
	}
	
//	faz uma procura, se o cadastro de funcionario exister volta true
	
	public Boolean confirmaFuncionario(String password, String username, ArrayList<funcionario> funcionarios) {
		int k =0;
		for(int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getUsername().equals(username) && 
					funcionarios.get(i).getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
	}
	
	public Boolean confirmaFuncionarioUsername(String username, ArrayList<funcionario> funcionarios) {
		int k =0;
		for(int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getUsername().equals(username)) {
				return true;
			}
			
		}
		return false;
	}
	
//	procura por nome retorna o id
	
	public int	procuraPorNomeFuncionario(String username, ArrayList<funcionario> funcionarios) {
		int k =0;
		for(int i = 0; i < funcionarios.size(); i++) {
			
			if(funcionarios.get(i).getUsername().equals(username)) {
				k = i;
			}
			
		}
		return funcionarios.get(k).getIdUsuario();
	}
	
}
