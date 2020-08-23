package com.modelo.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.modelo.projeto.entity.Endereco;
import com.modelo.projeto.transaction.EnderecoTransaction;

@Named
@ViewScoped
public class EnderecoPesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoTransaction enderecoTransaction;

	private List<Endereco> listaEnderecos;

	private String termoPesquisa;

	public void iniciar() {
		this.listaEnderecos = enderecoTransaction.todos();
	}

	public void pesquisar() {
		this.listaEnderecos = enderecoTransaction.pesquisar(termoPesquisa);
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
}
