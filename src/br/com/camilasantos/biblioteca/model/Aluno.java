package br.com.camilasantos.biblioteca.model;

public class Aluno extends Usuario {
	//private String id;
	//private String name;
	//private boolean ativo;
	private int quantEmprestimos;
	
	public Aluno (int ID, String name) {
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
