package br.com.camilasantos.biblioteca.service;
import java.util.ArrayList;

import br.com.camilasantos.biblioteca.model.Livro;
import br.com.camilasantos.biblioteca.model.Usuario;
import br.com.camilasantos.biblioteca.enums.Status;
import br.com.camilasantos.biblioteca.exception.ErrorException;
import br.com.camilasantos.biblioteca.model.Aluno;
import br.com.camilasantos.biblioteca.model.Emprestimo;

public  class Biblioteca implements BibliotecaService{
	private ArrayList <Livro> livros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Emprestimo> emprestimos;
	private int contador;
	private int i;
	private boolean encontrado = false;
	
	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
		this.usuarios = new ArrayList<Usuario>();
		this.emprestimos = new ArrayList<Emprestimo>();
		this.contador = 0;
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
	
	@Override
	public void cadastrarAluno(String name) {
		
		Aluno novoAluno = new Aluno(contador, name);
		
		usuarios.add(novoAluno);
		
		contador++;
	}
	
	@Override
	public ArrayList<Emprestimo> realizarEmprestimo(int idUsuario, int idLivro) throws ErrorException{
		
		Livro livro = buscarLivro(idLivro);
		//Livro livvro = this.livros.get(idLivro);
		Usuario usuario = buscarUsuario(idUsuario);
		
		if(livro == null) {
			throw new ErrorException("fail: livro não existe no acervo da biblioteca");
		}
		
		if(usuario == null) {
			throw new ErrorException("fail: usuario não está cadastrado");
		}
		
		livro.emprestar();
		
		Emprestimo novoemprestimo = new Emprestimo(usuario, livro);
		
		emprestimos.add(novoemprestimo);
		return emprestimos;
		
		
	}
	
	//@Override
	public ArrayList<Livro> listarlivrosEmprestados(int idUsuario) throws ErrorException{
		
		Usuario usuario = buscarUsuario(idUsuario);
		
		ArrayList<Livro> livrosativos = new ArrayList<Livro>();
		
		for(Emprestimo emprestimo : emprestimos) {
			if(usuario == null) {
				throw new ErrorException("fail: usuario não está cadastrado");
			}
			
			if(emprestimo.getUsuario() == usuario && emprestimo.getLivro().getStatus() == Status.EMPRESTADO){
				livrosativos.add(emprestimo.getLivro());
				
			}
 		}
		return livrosativos;
	}
	
	@Override
	public void realizarDevolucao(int idUsuario, int idLivro) throws ErrorException{
		
		Usuario usuario = buscarUsuario(idUsuario);
		
		Livro livro = buscarLivro(idLivro);
		
		if(usuario == null) {
			throw new ErrorException("fail: usuario não está cadastrado");
		}
		
		if(livro == null) {
			throw new ErrorException("fail: livro não existe no acervo da biblioteca");
		}
		
		for(int i = 0; i < emprestimos.size(); i++) {
			Emprestimo emprestimo = emprestimos.get(i);
			
			//if(usuario == null) {
			//	throw new ErrorException("fail: usuario não está cadastrado");
			//}
			
			if(emprestimo.getUsuario() == usuario && emprestimo.getLivro() == livro){
				//Emprestimo novoemprestimo = emprestimo;
				
				emprestimos.remove(i);
				encontrado = true;
				livro.devolver();
				break;
			}
			
			
 		}
		
		
		if(encontrado == false) {
			throw new ErrorException("fail: Usuario não está com esse livro");
		}
		
	}
	
	@Override
	public String toString() {
		String sai = "";
		
		sai += "====BEM-VINDO(A) AO SISTEMA VIRTUAL DA BIBLIOTECA SMILABOOK====\n\n";
		
		sai += "- Usuários Cadastrados:\n";
		for(Usuario usuario : usuarios) {
			sai += usuario + "\n";
		}
		
		sai += "\n- Livros do acervo:\n";
		for(Livro livro : livros) {
			sai +=  livro + "\n";
		}
		
		sai += "\n- Emprestimos realizados:\n";
		for(Emprestimo emprestimo : emprestimos) {
			sai += emprestimo + "\n";
		}
		
		return sai;
	}

	
	
}
