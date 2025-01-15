package br.edu.ifpe.main;

import br.edu.ifpe.entidades.*;
import br.edu.ifpe.persistencia.*;

import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		// Criando os DAOs
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		NoticiaDAO noticiaDAO = new NoticiaDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		TagDAO tagDAO = new TagDAO();

		// 1. Criando e salvando um Usuário
		Usuario usuario = new Usuario();
		usuario.setNome("Andrielly Firmino de Lima");
		usuario.setEmail("andrielly.firmino@email.com");
		usuarioDAO.salvar(usuario);
		System.out.println("Usuário salvo: " + usuario.getNome());

		// 2. Criando e salvando um Pagamento associado ao Usuário
		Pagamento pagamento = new Pagamento();
		pagamento.setValor(150.0);
		pagamento.setUsuario(usuario); // Associando ao usuário
		pagamentoDAO.salvar(pagamento);
		System.out.println("Pagamento realizado para o usuário: " + usuario.getNome());

		// 3. Criando e salvando um Perfil para o Usuário
		Perfil perfil = new Perfil();
		perfil.setDescricao("Perfil de Andrielly");
		perfil.setUsuario(usuario); // Associando ao usuário
		perfilDAO.salvar(perfil);
		System.out.println("Perfil criado para o usuário: " + usuario.getNome());

		// 4. Criando e salvando uma Notícia associada ao Perfil
		Noticia noticia = new Noticia();
		noticia.setTitulo("Notícia Importante");
		noticia.setConteudo("Conteúdo da notícia.");
		noticia.setPerfil(perfil); // Associando ao perfil
		noticiaDAO.salvar(noticia);
		System.out.println("Notícia criada pelo perfil: " + perfil.getDescricao());

		// 5. Criando e salvando uma Categoria
		Categoria categoria = new Categoria();
		categoria.setNome("Tecnologia");
		categoriaDAO.salvar(categoria);
		System.out.println("Categoria criada: " + categoria.getNome());

		// 6. Criando e salvando uma Tag
		Tag tag = new Tag();
		tag.setNome("Inovação");
		tagDAO.salvar(tag);
		System.out.println("Tag criada: " + tag.getNome());

		// Buscando e exibindo todos os usuários
		System.out.println("\nLista de usuários:");
		List<Usuario> usuarios = usuarioDAO.listar();
		for (Usuario u : usuarios) {
			System.out.println("Usuário: " + u.getNome());
		}

		// Buscando e exibindo todos os pagamentos
		System.out.println("\nLista de pagamentos:");
		List<Pagamento> pagamentos = pagamentoDAO.listar();
		for (Pagamento p : pagamentos) {
			System.out.println("Pagamento de: " + p.getUsuario().getNome() + " no valor de " + p.getValor());
		}

		// Buscando e exibindo todos os perfis
		System.out.println("\nLista de perfis:");
		List<Perfil> perfis = perfilDAO.listar();
		for (Perfil p : perfis) {
			System.out.println("Perfil de: " + p.getUsuario().getNome() + " - Descrição: " + p.getDescricao());
		}

		// Buscando e exibindo todas as notícias
		System.out.println("\nLista de notícias:");
		List<Noticia> noticias = noticiaDAO.listar();
		for (Noticia n : noticias) {
			System.out.println("Notícia: " + n.getTitulo() + " - Criada por: " + n.getPerfil().getDescricao());
		}

		// Buscando e exibindo todas as categorias
		System.out.println("\nLista de categorias:");
		List<Categoria> categorias = categoriaDAO.listar();
		for (Categoria c : categorias) {
			System.out.println("Categoria: " + c.getNome());
		}

		// Buscando e exibindo todas as tags
		System.out.println("\nLista de tags:");
		List<Tag> tags = tagDAO.listar();
		for (Tag t : tags) {
			System.out.println("Tag: " + t.getNome());
		}
	}
}
