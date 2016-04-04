package br.com.drogaria.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Funcionario f1 = new Funcionario();
		f1.setNome("João");
		f1.setCpf("320.586.985-7");
		f1.setSenha("123");
		f1.setFuncao("Gerente");

		Funcionario f2 = new Funcionario();
		f2.setNome("Leandro");
		f2.setCpf("329.586.985-7");
		f2.setSenha("456");
		f2.setFuncao("Advogado");

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.salvar(f1);
		dao.salvar(f2);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(1L);
		Funcionario f2 = dao.buscarPorCodigo(2L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Test
	@Ignore
	public void excluir() {

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcionario = dao.buscarPorCodigo(1L);

		dao.excluir(funcionario);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(2L);
		funcionario.setSenha("qsc");

		dao.editar(funcionario);
	}

	@Test
	@Ignore
	public void autenticar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Funcionario funcionario = funcionarioDAO.autenticar("944.747.258-32", "123456");

		Assert.assertNotNull(funcionario);
	}

}
