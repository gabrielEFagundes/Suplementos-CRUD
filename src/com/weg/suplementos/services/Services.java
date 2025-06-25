package com.weg.suplementos.services;
import com.weg.suplementos.model.Suplementos;
import com.weg.suplementos.view.View;
import com.weg.suplementos.AppSuplementos;

import java.util.List;
import java.util.ArrayList;

public class Services {
	
	List<Suplementos> meusSuplementos = new ArrayList<>();
	
	Suplementos suplemento = new Suplementos();
	View view = new View();
	
	public void gerenciarSuplementos(int escolhaMenu) {
		switch(escolhaMenu) {
		case 1 -> {
				cadastrarSuplemento();
			}
		
		case 2 -> {
				int listarEscolha = view.listarEscolha();
				
				if(listarEscolha == 1) {
					view.listarTudo(meusSuplementos);
					
				}else if(listarEscolha == 2) {
					view.listarPorNome(meusSuplementos);
					
				}
			}
		
		case 3 -> {
				int indiceEdicao = view.alterarSuplemento(meusSuplementos);
			
				editarSuplemento(indiceEdicao);
			}
		
		case 4 -> {
				String nomeSuplemento = view.removerSuplemento(meusSuplementos);
				
				deletarSuplemento(nomeSuplemento);
			}
		
		case 5 -> {
				int cont = contarCadastros();
				
				view.qtdCadastros(cont);
			}
		
		case 0 -> {
				view.fecharScanner();
				System.exit(0);
					
			}
		}
		
	}
	
	public void cadastrarSuplemento() {
		String nomeSuplemento = view.cadastrarNome();
		
		double preco = view.cadastrarPreco();
		
		int quantidade = view.cadastrarQuantidade();
		
		String marca = view.cadastrarMarca();
		
		suplemento = new Suplementos(nomeSuplemento, preco, quantidade, marca);
		
		meusSuplementos.add(suplemento);
		
	}
	
	public void deletarSuplemento(String nomeSuplemento) {
		int cont = 0;
		
		for(Suplementos i : meusSuplementos) {
			if(i.getNome().equalsIgnoreCase(nomeSuplemento)) {
				meusSuplementos.remove(cont);
			}else {
				cont++;
			}
		}
	}
	
	public int contarCadastros() {
		int cont = 0;
		
		while(cont < meusSuplementos.size()) {
			cont++;
		}
		
		return cont;
		
	}
	
	public void editarSuplemento(int indiceElemento) {
		String nomeNovo = view.cadastrarNome();
		
		double precoNovo = view.cadastrarPreco();
		
		int quantidadeNova = view.cadastrarQuantidade();
		
		String marcaNova = view.cadastrarMarca();
		
		suplemento = new Suplementos(nomeNovo, precoNovo, quantidadeNova, marcaNova);
		
		meusSuplementos.set(indiceElemento, suplemento);
	}
	
}
