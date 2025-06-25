package com.weg.suplementos.view;
import com.weg.suplementos.model.Suplementos;
import com.weg.suplementos.services.Services;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	Scanner scan = new Scanner(System.in);
	
	public int menuPrincipal() {
		
		System.out.println("\n===== Suplementos G.O.A.T ====="
				+ "\n1- Cadastrar suplemento"
				+ "\n2- Listar suplementos"
				+ "\n3- Editar suplementos"
				+ "\n4- Remover suplementos pelo nome"
				+ "\n5- Contar suplementos cadastrados"
				+ "\n0- Sair do sistema"
				+ "\nSua escolha: ");
		
		int escolha = scan.nextInt();
		
		return escolha;
		
	}
	
	public String cadastrarNome() {
		System.out.println("\nDigite o nome do suplemento: ");
		String nomeSuplemento = scan.nextLine();
		
		return nomeSuplemento;
	}
	
	public double cadastrarPreco() {
		System.out.println("\nDigite o preço do suplemento: ");
		double precoSuplemento = scan.nextDouble();
		
		return precoSuplemento;
	}
	
	public int cadastrarQuantidade() {
		System.out.println("\nDigite a quantidade do suplemento: ");
		int qtdSuplemento = scan.nextInt();
		
		return qtdSuplemento;
	}

	public String cadastrarMarca() {
		scan.nextLine();
		System.out.println("\nDigite a marca do suplemento: ");
		String marcaSuplemento = scan.nextLine();
		
		return marcaSuplemento;
	}
	
	public int listarEscolha() {
		System.out.println("\nComo você deseja listar os suplementos?"
				+ "\n1- Listar todos os suplementos"
				+ "\n2- Listar por nome"
				+ "\nSua escolha: ");
		
		int escolhaListagem = scan.nextInt();
		
		return escolhaListagem;
	}
	
	public void listarTudo(List<Suplementos> meusSuplementos) {
		System.out.println("Nome\t|\tPreço\t|\tQuantidade\t|\tMarca");
		
		for(Suplementos i : meusSuplementos) {
			System.out.println(i.getNome() + "\t|\t" + i.getPreco() + "\t|\t" + i.getQuantidade() + "\t\t|\t" + i.getMarca());
			
		}
		scan.nextLine(); //buffer tava errado
	}
	
	// resolvido, era o buffer
	public void listarPorNome(List<Suplementos> meusSuplementos) {
		scan.nextLine();
		
		boolean encontrado = false;
		
		System.out.println("\nDigite o nome do suplemento: ");
		String nomeSuplemento = scan.nextLine();
		
		for(Suplementos i : meusSuplementos) {
				
			if(i.getNome().equalsIgnoreCase(nomeSuplemento)) {
				encontrado = true;
				System.out.println("Nome\t|\tPreço\t|\tQuantidade\t|\tMarca");
				System.out.println(i.getNome() + "\t|\t" + i.getPreco() + "\t|\t" + i.getQuantidade() + "\t\t|\t" + i.getMarca());
				break;
					
			}
		}
		
		if(!encontrado) {
			System.err.println("\nSuplemento não encontrado.");
		}
	}
	
	public int alterarSuplemento(List<Suplementos> meusSuplementos) {
		for(int cont = 0; cont < meusSuplementos.size(); cont++) {
			for(Suplementos i : meusSuplementos) {
				System.out.println((cont+1) + "- " + i.getNome() + "\n");
				
			}
		}
		System.out.printf("Digite o número do suplemento que você deseja editar: ");
		int indiceElemento = scan.nextInt();
		
		indiceElemento -= 1; //igualar ao indice real
		scan.nextLine();
		
		return indiceElemento;
		
	}
	
	// TODO: resolver isso também, por algum motivo do além, isso aqui só aceita int ',:/
	public String removerSuplemento(List<Suplementos> meusSuplementos) {
		System.out.println();
		for(Suplementos i : meusSuplementos) {
			System.out.println("> " + i.getNome());
		}
		
		System.out.println("\nDigite o nome do suplemento que você quer remover: ");
		String nomeRemover = scan.nextLine();
		
		return nomeRemover;
	}
	// tá tudo funcionando certinho, mas isso aqui... EU NÃO SEI POR QUE ISSO NÃO FUNCIONA Dx
	
	public void qtdCadastros(int cont) {
		System.out.println("\nA quantidade atual de cadastros é de: " + cont);
		
	}
	
	public void fecharScanner() {
		scan.close();
	}
	
}
