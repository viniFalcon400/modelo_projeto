package com.modelo.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.modelo.projeto.entity.Pessoa;
import com.modelo.projeto.transaction.PessoaTransaction;

@Named
@ViewScoped
public class PessoaPesquisaBean implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Inject
    private PessoaTransaction pessoaTransaction;

    private List<Pessoa> listaPessoas;
    
    private String termoPesquisa;
	
	public void iniciar() {
		this.listaPessoas = this.pessoaTransaction.todos();
	}
	
	public void pesquisar() {
	    this.listaPessoas = this.pessoaTransaction.pesquisar(termoPesquisa);
	}
	
	public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
	
	public String getTermoPesquisa() {
        return termoPesquisa;
    }
	
	public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
}