package com.modelo.projeto.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.modelo.projeto.entity.Endereco;
import com.modelo.projeto.entity.EnumEstado;
import com.modelo.projeto.transaction.EnderecoTransaction;
import com.modelo.projeto.util.Transacional;
import java.util.ResourceBundle;

/**
 *
 * @author vcoelho
 */
@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoTransaction enderecoTransaction;

	private Endereco endereco = new Endereco();

	public void buscar() {
		endereco = enderecoTransaction.buscar(endereco.getId());
	}

	@Transacional
	public void salvar() throws Exception {
		if (endereco != null && enderecoTransaction.buscarCep(endereco.getId(), endereco.getCep()) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/Messages").getString("msg_CEP_ja_cadastrado"), ResourceBundle.getBundle("/Messages").getString("msg_CEP_ja_cadastrado")));
		} else if (endereco == null || endereco.getId() == null) {
			enderecoTransaction.insert(endereco);
		} else {
			enderecoTransaction.update(endereco);
		}
	}

	@Transacional
	public String remover() {
		enderecoTransaction.remover(endereco);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Endereco removido com sucesso!"));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "endereco/endereco-pesquisa?faces-redirect=true";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public EnumEstado[] getEstadoArray() {
		return EnumEstado.values();
	}
}
