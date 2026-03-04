package br.com.camilasantos.biblioteca.model;

public class Funcionario extends Usuario{
	//private String id;
	//private String name;
	//private boolean ativo;
	//private int quantEmprestimos;
	
	public Funcionario (int ID, String name) {
		super (ID, name);
		//this.quantEmprestimos = 0;
	}
	
	public String toString() {
		return super.toString();
	}
}
