package Operacoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Carro.carro;
import Usuarios.cliente;
import Usuarios.funcionario;

public class arquivoManipula {

	public ArrayList<cliente> puxaClientes(ArrayList<cliente> clientes){
		
		String caminhoArquivo = "src/dados/dadosClientes";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
			
			String linha;
			
			while((linha = br.readLine()) != null) {
				
				String[] valores = linha.split(",");
				
				if (valores.length == 3) {
					
                    int idUsuario = Integer.parseInt(valores[0].trim());
                    String username = valores[1].trim();
                    String password = valores[2].trim();
                    cliente clienteNovo = new cliente(idUsuario, username, password);
                    clientes.add(clienteNovo);
                    
                } else {
                    System.out.println("erro ao ler a linha: " + linha);
                }
				
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return clientes;
		
	}
	
	public void registraClientes(ArrayList<cliente> clientes) {
		
		String caminhoArquivo = "src/dados/dadosClientes";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (cliente cliente1 : clientes) {
                String linha = formatarClienteParaEscrita(cliente1);
                bw.write(linha);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public ArrayList<carro> puxaCarros(ArrayList<carro> carros){
			
			String caminhoArquivo = "src/dados/dadosCarros";
			
			try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
				
				String linha;
				
				while((linha = br.readLine()) != null) {
					
					String[] valores = linha.split(",");
			
	                int idCarro = Integer.parseInt(valores[0].trim());
	                String marca = valores[1].trim();
	                String modelo = valores[2].trim();
	                String tipoCombustivel = valores[3].trim();
	                String placa = valores[4].trim();
	                int ano = Integer.parseInt(valores[5].trim());
	                double quilometragem = Double.parseDouble(valores[6].trim());
	                double preco = Double.parseDouble(valores[7].trim());
	                
	                carro clienteNovo = new carro(idCarro, marca, modelo, tipoCombustivel, placa, ano, quilometragem, preco);
	                carros.add(clienteNovo);
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return carros;
			
		}
	
	    
	    
	public void registraCarro(ArrayList<carro> carros) {
			
			String caminhoArquivo = "src/dados/dadosCarros";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
	            for (carro carro1 : carros) {
	                String linha = formatarCarroParaEscrita(carro1);
	                bw.write(linha);
	                bw.newLine();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
		
	public ArrayList<funcionario> puxaFuncionarios(ArrayList<funcionario> funcionarios){
			
			String caminhoArquivo = "src/dados/dadosFuncionarios";
			
			try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
				
				String linha;
				
				while((linha = br.readLine()) != null) {
					
					String[] valores = linha.split(",");
			
					int idUsuario = Integer.parseInt(valores[0].trim());
	                String username = valores[1].trim();
	                String password = valores[2].trim();
	                String cargo = valores[3].trim();
	                String horario = valores[4].trim();
	                int totalVendas = Integer.parseInt(valores[5].trim());
	                double totalValorVenda = Double.parseDouble(valores[6].trim());
	                
	                
	                funcionario funcionarioNovo = new funcionario(idUsuario, username, password, cargo, horario, totalVendas, totalValorVenda);
	                funcionarios.add(funcionarioNovo);
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return funcionarios;
			
		}
	
	    
	    
	public void registrafuncionario(ArrayList<funcionario> funcionarios) {
			
			String caminhoArquivo = "src/dados/dadosFuncionarios";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
	            for (funcionario funcionario: funcionarios) {
	                String linha = formatarFuncionarioParaEscrita(funcionario);
	                bw.write(linha);
	                bw.newLine();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	
	private static String formatarFuncionarioParaEscrita(funcionario funcionario) {
		
		return funcionario.getIdUsuario() + "," + 
				funcionario.getUsername() + "," + 
				funcionario.getPassword() + "," + 
				funcionario.getCargo() + "," + 
				funcionario.getHorario() + "," + 
				funcionario.getTotalVendas() + "," + 
				funcionario.getTotalValorVenda();
		
	}
	
	private static String formatarCarroParaEscrita(carro carro) {
	    return carro.getIdCarro() + "," +
	            carro.getMarca() + "," +
	            carro.getModelo() + "," +
	            carro.getTipoCombustivel() + "," +
	            carro.getPlaca() + "," +
	            carro.getAno() + "," +
	            carro.getQuilometragem() + "," +
	            carro.getPreco();
	}	// deixei assim pq eh mt variavel plmrds
	
	private static String formatarClienteParaEscrita(cliente cliente) {
	    return cliente.getIdUsuario() + "," + cliente.getUsername() + "," + cliente.getPassword();
	}	
	
	public ArrayList<cliente> reordenarIdsClientes(ArrayList<cliente> clientes) {
		for(int i = 0; i < clientes.size(); i++) {
			clientes.get(i).setIdUsuario(i);
		}
		return clientes;
    }
	public ArrayList<funcionario> reordenarIdsFuncionarios(ArrayList<funcionario> funcionarios) {
		for(int i = 0; i < funcionarios.size(); i++) {
			funcionarios.get(i).setIdUsuario(i+10000);
		}
		return funcionarios;
	}
	public ArrayList<carro> reordenarIdsCarros(ArrayList<carro> carros) {
		for(int i = 0; i < carros.size(); i++) {
			carros.get(i).setIdCarro(i);
		}
		return carros;
	}
		
}
