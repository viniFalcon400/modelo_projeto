package com.modelo.projeto.entity;

import java.io.Serializable;

/**
 *
 * @author vcoelho
 */
public class EnderecoDTO implements Serializable {

	private Long id;
	private String descricao;

	public EnderecoDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
