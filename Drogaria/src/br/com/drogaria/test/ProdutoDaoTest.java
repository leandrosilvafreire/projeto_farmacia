package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDaoTest {
	@Test
	@Ignore
	public void inserir() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(7L);

		Produto produto = new Produto();
		produto.setDescricao("Leite Nilza Integral 1L");
		produto.setPreco(new BigDecimal(23.97D));
		produto.setQuantidade(100);
		produto.setFabricante(fabricante);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(4L);
		System.out.println(produto);
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listar();
		System.out.println(produtos);
	}

	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(8L);
		produtoDAO.excluir(produto);

	}

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		Produto produto = produtoDAO.buscarPorCodigo(1L);
		produto.setDescricao("Coca-Cola 2L");
		produto.setPreco(new BigDecimal(8.99D));
		produto.setQuantidade(20);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);
	}

}
