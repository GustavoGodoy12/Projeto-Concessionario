package Main;

import java.util.ArrayList;

import Carro.carro;
import Menu.menuCadastro;
import Menu.menuInicial;
import Menu.menuLogin;
import Menu.menuPrincipal;
import Operacoes.arquivoManipula;
import Usuarios.cliente;
import Usuarios.funcionario;

//Trabalho Java
// main - Determina o fluxo do codigo

public class main {

	public static void main(String[] args) {
		
		int idUserLogged = 0;	// <- id do usuario que fez o Log In
		int opt = 0;			// <- opcao que o usuario selecionou no menuInicial
		
		arquivoManipula arquivoManipula = new arquivoManipula();
		
		ArrayList<cliente> clientes = new ArrayList<>();
		clientes = arquivoManipula.puxaClientes(clientes);
		clientes = arquivoManipula.reordenarIdsClientes(clientes);
		
		ArrayList<carro> carros = new ArrayList<>();
		carros = arquivoManipula.puxaCarros(carros);
		carros = arquivoManipula.reordenarIdsCarros(carros);
		
		ArrayList<funcionario> funcionarios = new ArrayList<>();
		funcionarios = arquivoManipula.puxaFuncionarios(funcionarios);
		funcionarios = arquivoManipula.reordenarIdsFuncionarios(funcionarios);
		
		for(int i = 0; i < funcionarios.size(); i++) {
			System.out.println(funcionarios.get(i).getUsername());
		}
		
		// menus
		menuInicial menuIni = new menuInicial();
		menuLogin menuLogin = new menuLogin();
		menuCadastro menuCadastro = new menuCadastro();
		menuPrincipal menuPrincipal = new menuPrincipal();
		
		while(true) {
			
			opt = menuIni.menu(opt);
			
			if(opt == 0) {
				break;
			}
			if(opt == 1) {
				idUserLogged = menuLogin.menuLogin(opt, idUserLogged, clientes, funcionarios);
				System.out.println(idUserLogged);
			}
			if(opt == 2) {
				menuCadastro.cadastroCliente(clientes);
			}
			
			while(idUserLogged > 0) {
				
				opt = menuPrincipal.menuPrincipal(idUserLogged, opt, carros, funcionarios, clientes);
				
				if(opt == -1) { //volta pro menu anterior
					idUserLogged = 0;
					break;
				}
				
			}
			
		}

	}

}
