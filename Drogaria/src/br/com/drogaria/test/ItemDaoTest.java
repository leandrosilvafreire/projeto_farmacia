package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemDaoTest {

	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);

		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(13);
		item.setValor(new BigDecimal(22.22D));
		item.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);

	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item> itens = itemDAO.listar();

		System.out.println(itens);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(19L);
		System.out.println(item);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(26L);
		itemDAO.excluir(item);
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(4L);

		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(3L);

		item.setProduto(produto);
		item.setQuantidade(8);
		item.setValor(new BigDecimal(425.65D));
		item.setVenda(venda);

		itemDAO.editar(item);

	}

}
