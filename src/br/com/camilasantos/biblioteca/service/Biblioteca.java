package br.com.camilasantos.biblioteca.service;
import java.util.ArrayList;

import br.com.camilasantos.biblioteca.model.Livro;
import br.com.camilasantos.biblioteca.model.Usuario;
import br.com.camilasantos.biblioteca.enums.Status;
import br.com.camilasantos.biblioteca.exception.ErrorException;
import br.com.camilasantos.biblioteca.model.Aluno;
import br.com.camilasantos.biblioteca.model.Emprestimo;

public abstract class Biblioteca implements BibliotecaService{
	private ArrayList <Livro> livros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Emprestimo> emprestimos;
	private int contador;
	//private int i;
	
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
		this.usuarios = new ArrayList<Usuario>();
		this.emprestimos = new ArrayList<Emprestimo>();
		this.contador = 1;
	}
	
	private Livro buscarLivro(int id) {
		for(Livro livro : livros) {
			if(livro.getId() == id) {
				return livro;
			}
		}
		
		return null;
	}
	private Usuario buscarUsuario(int id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getID() == id) {
				return usuario;
			}
		}
		
		return null;
	}
	
	@Override
	 public void cadastrarLivro(String titulo, String autor) {

        Livro novoLivro = new Livro(titulo, autor, contador);

        livros.add(novoLivro);

        contador++;
    }
	
	public void cadastrarAluno(String name) {
		
		Aluno novoAluno = new Aluno(contador, name);
		
		usuarios.add(novoAluno);
		
		contador++;
	}
	
	public ArrayList<Emprestimo> realizarEmprestimos(int idUsuario, int idLivro) throws ErrorException{
		
		Livro livro = buscarLivro(idLivro);
		//Livro livvro = this.livros.get(idLivro);
		Usuario usuario = buscarUsuario(idUsuario);
		
		if(livro == null) {
			throw new ErrorException("fail: livro não existe no acervo da biblioteca");
		}
		
		if(usuario == null) {
			throw new ErrorException("fail: usuario não cadastrado");
		}
		
		livro.emprestar();
		
		Emprestimo novoemprestimo = new Emprestimo(usuario, livro);
		
		emprestimos.add(novoemprestimo);
		return emprestimos;
		
		
	}
	
	public ArrayList<Livro> listarlivrosEmprestados(int idUsuario) {
		
	}
	
	
	
}
