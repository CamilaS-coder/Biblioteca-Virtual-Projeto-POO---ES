package br.com.camilasantos.biblioteca.model;

public abstract class Usuario {
	private String ID;
	private String name;
	private boolean ativo;
	
	public Usuario (String ID, String name) {
		this.ID = ID;
		this.name = name;
		this.ativo = false;
	}
	
	public String getID() {
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
		return this.ID + " " + this.name;
	}
}
