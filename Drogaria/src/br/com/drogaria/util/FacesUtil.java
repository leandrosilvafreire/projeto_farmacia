package br.com.drogaria.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesUtil {
	public static void adicionarMsgInfo(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);

		facesContext.addMessage(null, facesMessage);

	}

	public static void adicionarMsgErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);

		facesContext.addMessage(null, facesMessage);

	}

	public static String getParam(String nome) {

		// captura o contexto da aplica��o como um todo
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Contexto do navegador
		ExternalContext externalContext = facesContext.getExternalContext();

		// Mapeia todos os par�metros
		Map<String, String> parametros = externalContext.getRequestParameterMap();

		// Seleciona o que eu quero
		String valor = parametros.get(nome);

		// retorna o valor que eu quero
		return valor;
	}

}
