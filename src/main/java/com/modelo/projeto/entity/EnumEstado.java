package com.modelo.projeto.entity;

/**
 *
 * @author vcoelho
 */
public enum EnumEstado {

	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amapá"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");

	EnumEstado(String codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	private final String codigo;
	private final String tipo;

	public String getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}
}
