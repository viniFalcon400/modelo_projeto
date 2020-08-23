package com.modelo.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vcoelho
 */
@Entity
@NamedQuery(name = "Usuario.findUser", 
		    query= "SELECT u FROM Usuario u WHERE u.nomeUsuario = :usuario AND u.senha = :senha")
@XmlRootElement
public class Usuario implements Serializable {

	private Long id;
	private String nomeUsuario;
	private String senha;
	private Date ultimoAcesso;

	public Usuario() {
	}

	public Usuario(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome", nullable = false, unique = true, length = 150)
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(name = "senha", nullable = false, unique = false,length = 150)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "dt_ultimo_acesso", unique = true)
	@Temporal(TemporalType.DATE)
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
}
