package br.com.camilasantos.biblioteca.model;

public abstract class Usuario {
	private int ID;
	private String name;
	private boolean ativo;
	
	public Usuario (int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.ativo = false;
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
		return this.ID + " " + this.name;
	}
}
