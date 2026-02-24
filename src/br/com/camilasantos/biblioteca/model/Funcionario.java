package br.com.camilasantos.biblioteca.model;

public class Funcionario extends Usuario{
	//private String id;
	//private String name;
	//private boolean ativo;
	private int quantEmprestimos;
	
	public Funcionario (String ID, String name) {
		super (ID, name);
		this.quantEmprestimos = 0;
	}
	
	public int getQuantEmprestimos() {
		return this.quantEmprestimos;
	}
	
	public void adicEmprestimo() {
		this.quantEmprestimos++;
		return;
	}
	
	public void remoEmprestimo() {
		this.quantEmprestimos--;
		return;
	}
	
	public String toString() {
		return super.toString() + " " + this.quantEmprestimos;
	}
}
