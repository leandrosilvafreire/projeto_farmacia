package br.com.drogaria.util;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.drogaria.bean.LoginBean;
import br.com.drogaria.domain.Funcionario;

@SuppressWarnings("serial")
public class AutenticacaoPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();

		boolean ehPaginaAutenticacao = paginaAtual.contains("login.xhtml");

		if (!ehPaginaAutenticacao) {
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> mapa = externalContext.getSessionMap();
			LoginBean loginBean = (LoginBean) mapa.get("loginBean");
			System.out.println("loginBean" + loginBean);

			Funcionario funcionario = loginBean.getFuncionarioLogado();

			if (funcionario.getFuncao() == null) {
				FacesUtil.adicionarMsgErro("Funcionário não autenticado.");

				Application application = facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/login.xhtml?faces-redirect=true");
			}
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RESTORE_VIEW;
	}

}
