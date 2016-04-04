package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricanteCadastro;
	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listarFabricantesFiltrados;
	private String acao;
	private Long codigo;

	public Fabricante getFabricanteCadastro() {
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListarFabricantesFiltrados() {
		return listarFabricantesFiltrados;
	}

	public void setListarFabricantesFiltrados(List<Fabricante> listarFabricantesFiltrados) {
		this.listarFabricantesFiltrados = listarFabricantesFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	// Controle
	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.adicionarMsgInfo("Fabricante cadastrado com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgErro("Erro ao tentar incluir um fabricante: " + ex.getMessage());
		}

	}

	public void novo() {
		fabricanteCadastro = new Fabricante();
	}

	public void carregarPesquisa() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os fabricantes: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);
			} else {
				fabricanteCadastro = new Fabricante();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao selecionar o fabricante: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricanteCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante removido com sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover o fabricante: " + ex.getMessage());
		}

	}

	public void editar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricanteCadastro);

			FacesUtil.adicionarMsgInfo("Fabricante atualizado com sucesso");

		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgErro("Erro ao tentar atualizar o fabricante: " + ex.getMessage());

		}
	}

}
