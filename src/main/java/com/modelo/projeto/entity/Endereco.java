package com.modelo.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vcoelho
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Endereco.findCep", query = "Select e From Endereco e Where e.cep = :cep And e.id <> :id")})
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cidade;
	private EnumEstado estado;
	private String logradouto;
	private String bairro;
	private Integer numero;
	private String cep;
	private Date dataModificacao;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "endereco")
	@TableGenerator(name = "endereco")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 150)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Enumerated(EnumType.STRING)
	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	@Column(nullable = false, length = 150)
	public String getLogradouto() {
		return logradouto;
	}

	public void setLogradouto(String logradouto) {
		this.logradouto = logradouto;
	}

	@Column(nullable = false, length = 150)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(nullable = false, length = 8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_modificacao", nullable = false)
	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public String toString() {
		return "Cidade: " + cidade + ", Logradouto: " + logradouto;
	}

}
