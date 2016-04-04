package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDaoTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAOA");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAOB");

		Fabricante f3 = new Fabricante();
		f3.setDescricao("DESCRICAOC");

		FabricanteDAO dao = new FabricanteDAO();

		dao.salvar(f1);
		dao.salvar(f2);
		dao.salvar(f3);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);

		/*
		 * for (Fabricante fabricante : fabricantes) {
		 * System.out.println(fabricante); }
		 */
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(3L);
		Fabricante f2 = dao.buscarPorCodigo(2L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Test
	@Ignore
	public void excluir() {

		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(8L);

		dao.excluir(fabricante);

		// Fabricante fabricante = new Fabricante();
		// fabricante.setCodigo(5L);
		// fabricante.setDescricao("DESCRICAOA");
		//
		// FabricanteDAO dao = new FabricanteDAO();
		// dao.excluir(fabricante);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void excluirPorCodigo() { FabricanteDAO dao = new
	 * FabricanteDAO();
	 * 
	 * dao.excluir(15L); }
	 */

	@Test
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(8L);
		fabricante.setDescricao("DESCRICAOP");

		dao.editar(fabricante);
	}

}
