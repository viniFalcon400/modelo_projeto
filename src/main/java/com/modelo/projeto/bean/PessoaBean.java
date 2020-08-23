package com.modelo.projeto.bean;

import com.modelo.projeto.entity.Endereco;
import com.modelo.projeto.entity.EnumSexo;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.modelo.projeto.entity.Pessoa;
import com.modelo.projeto.transaction.EnderecoTransaction;
import com.modelo.projeto.transaction.PessoaTransaction;
import com.modelo.projeto.util.Transacional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.model.SelectItem;

/**
 *
 * @author vcoelho
 */
@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaTransaction pessoaTransaction;
	@Inject
	private EnderecoTransaction enderecoTransaction;

	private Pessoa pessoa = new Pessoa();
	private Long idEndereco;

	public void buscar() {
		pessoa = pessoaTransaction.buscar(pessoa.getId());
		if (pessoa != null) {
			if (pessoa.getEndereco() != null) {
				idEndereco = pessoa.getEndereco().getId();
			}
		}
	}

	@Transacional
	public void salvar() throws Exception {
		if (idEndereco != null) {
			Endereco endereco = new Endereco();
			endereco.setId(idEndereco);
			pessoa.setEndereco(endereco);
		}
		if (pessoa != null && pessoa.getDataNascimento() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Nascimento: Erro de validação: o valor é necessário.", "Data Nascimento: Erro de validação: o valor é necessário."));
		} else if (pessoa != null && pessoaTransaction.buscarCpf(pessoa.getId(), pessoa.getCpf()) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/Messages").getString("msg_CPF_ja_cadastrado"), ResourceBundle.getBundle("/Messages").getString("msg_CPF_ja_cadastrado")));
		} else if (pessoa == null || pessoa.getId() == null) {
			pessoaTransaction.insert(pessoa);
		} else {
			pessoaTransaction.update(pessoa);
		}
	}

	@Transacional
	public String remover() {
		pessoaTransaction.remover(pessoa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa removida com sucesso!"));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "pessoa/pessoa-pesquisa?faces-redirect=true";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public EnumSexo[] getSexoArray() {
		return EnumSexo.values();
	}

	public List<SelectItem> getEnderecoItem() {
		List<SelectItem> enderecoItens = new ArrayList<>();
		List<Endereco> list = enderecoTransaction.todos();
		list.stream().map((e) -> new SelectItem(e.getId(), e.getCidade() + " - " + e.getLogradouto())).forEachOrdered((selecao) -> {
			enderecoItens.add(selecao);
		});
		return enderecoItens;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
}
