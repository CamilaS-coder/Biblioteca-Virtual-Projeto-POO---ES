package br.com.camilasantos.biblioteca.model;

public abstract class Usuario {
	private int ID;
	private String name;
	private boolean ativo;
	private int quantEmprestimos;
	
	public Usuario (int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.ativo = false;
		quantEmprestimos = 0;
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
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isAtivo() {
		//this.ativo = true;
		return this.ativo;
	}
	
	public void setName(String name) {
		this.name = name;
		return;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = true;
		return;
	}
	
	public String toString() {
		return "[ " + "Código de Segurança: " + this.ID + " ] " + "[ " + "Nome do Usuário: " + this.name + " ] " + "[ " +  "Nº de emprestimos: " + getQuantEmprestimos() + " ]" +  "\n";
	}
}
