package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Funcionario funcionarioLogado;

	public Funcionario getFuncionarioLogado() {
		if (funcionarioLogado == null) {
			funcionarioLogado = new Funcionario();
		}
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public String autenticar() {
		try {
			// Conferir com os dados do banco
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioLogado = funcionarioDAO.autenticar(funcionarioLogado.getCpf(), funcionarioLogado.getSenha());

			if (funcionarioLogado == null) {
				FacesUtil.adicionarMsgErro("CPF ou senha inv�lidos");
				return null;
			} else {
				FacesUtil.adicionarMsgInfo("Funcion�rio autenticado com sucesso");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar autenticar no sistema: " + ex.getMessage());
			return null;
		}
	}

	public String sair() {
		funcionarioLogado = null;
		return "/pages/login.xhtml?faces-redirect=true";
	}

}
