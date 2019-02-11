package br.com.fiap.teste;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import br.com.fiap.anotacoes.Coluna;
import br.com.fiap.anotacoes.Tabela;
import br.com.fiap.bean.Carro;

public class teste {

	public static void main(String[] args) {
		Carro carro = new Carro();
		//criarTabela(carro);
		criarSelect(carro);
	}

	public static void criarTabela(Object obj) {
		//api reflection vamos recuperar o nome da classe
		String nome = obj.getClass().getName();
		System.out.println(nome);
		//recueprar os atributos da classe
		Field[] atributos = obj.getClass().getDeclaredFields();
		for(Field f: atributos) {
			String nomew = f.getName();
			//recueprar anotacao
			Coluna anotacao = f.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
			System.out.println(anotacao.tipo());
			System.out.println(anotacao.obrigatorio());
	}
}
	public static void criarSelect(Object obj) {
		//Recuperar o nome configurado na @tabela
		Tabela tabela = obj.getClass().getAnnotation(Tabela.class);
		//exibir o sql
		System.out.println("Select * from " + tabela.nome());
	}
}