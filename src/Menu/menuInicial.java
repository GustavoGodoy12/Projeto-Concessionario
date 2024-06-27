package Menu;

import java.util.Scanner;

//	somente para os menus/paineis de opcoes

public class menuInicial {

	Scanner scannerNum = new Scanner(System.in);
	
	public int menu(int opt) {
		
		while(true) {
			
			System.out.println("==================================================================================");
			System.out.println("    ___                                    _                             _        ");
	        System.out.println("   / __\\ ___   _ __    ___  ___  ___  ___ (_)  ___   _ __    __ _  _ __ (_)  __ _ ");
	        System.out.println("  / /   / _ \\ | '_ \\  / __|/ _ \\/ __|/ __|| | / _ \\ | '_ \\  / _` || '__|| | / _` |");
	        System.out.println(" / /___| (_) || | | || (__|  __/\\__ \\\\__ \\| || (_) || | | || (_| || |   | || (_| |");
	        System.out.println(" \\____/ \\___/ |_| |_| \\___|\\___||___/|___/|_| \\___/ |_| |_| \\__,_||_|   |_| \\__,_|");
	        System.out.println("                                                                                  ");
	        System.out.println("==================================================================================");
	        System.out.println("__________________________________________________________________________________");
	        System.out.println("|                1. LOG-IN                 ||            2. REGISTRAR            |");
	        System.out.println("|__________________________________________||____________________________________|");
	        System.out.println("|                0. SAIR                   ||                                    |");
	        System.out.println("|__________________________________________||____________________________________|");
        	opt = scannerNum.nextInt();
        	
            if(opt < 0 || opt > 3) {
            	System.out.print("\033[H\033[2J"); // <- clear screen para ANSI, pode nao funcionar em todos terminais
                System.out.flush();
            }else {
            	break;
            }
        }
        
        
        return opt;
	}
	
}
