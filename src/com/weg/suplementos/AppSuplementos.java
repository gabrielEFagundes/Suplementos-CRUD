package com.weg.suplementos;
import com.weg.suplementos.view.View;
import com.weg.suplementos.services.Services;
import com.weg.suplementos.model.Suplementos;

public class AppSuplementos {
	
	public static void main(String [] args) {
		
		View view = new View();
		Services services = new Services();
		
		boolean programa = true;
		
		do {
			
			int escolhaMenu = view.menuPrincipal();
			
			services.gerenciarSuplementos(escolhaMenu);
			
		}while(programa);
		
	}

}
