package com.modelo.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author vcoelho
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Pessoa.findCpf", query = "Select p From Pessoa p Where p.cpf = :cpf And p.id <> :id")})
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private EnumSexo sexo;
	private Date dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	private Date dataModificacao;
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pessoa")
	@TableGenerator(name = "pessoa")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 150)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false, length = 14)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(length = 100)
	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	@Column(length = 100)
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Enumerated(EnumType.STRING)
	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	/**
	 *
	 * @return
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_modificacao", nullable = false)
	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@JoinColumn(name = "id_endereco", referencedColumnName = "id")
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + '}';
	}

}
