package br.com.drogaria.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;
import br.com.drogaria.filter.VendaFilter;

public class VendaDaoTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDao.buscarPorCodigo(2L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(365.99D));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();

		List<Venda> vendas = vendaDAO.listar();
		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(8L);
		System.out.println(venda);
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		vendaDAO.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(3L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(3L);

		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(875.46));
		venda.setFuncionario(funcionario);

		vendaDAO.editar(venda);

	}

	@Test
	@Ignore
	public void buscar() throws ParseException {
		// Conversão da data do tipo String para o formato date
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		VendaFilter filtro = new VendaFilter();
		filtro.setDataInicial(formato.parse("27/09/2015"));
		filtro.setDataFinal(formato.parse("03/10/2015"));

		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> vendas = vendaDAO.buscar(filtro);

		for (Venda venda : vendas) {
			System.out.println(venda);
		}
	}

}
