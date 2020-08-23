package com.modelo.projeto.entity;

/**
 *
 * @author vcoelho
 */
public enum EnumEstado {

	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amap�"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Cear�"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Esp�rito Santo"),
	GO("GO", "Goi�s"),
	MA("MA", "Maranh�o"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Par�"),
	PB("PB", "Para�ba"),
	PR("PR", "Paran�"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piau�"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rond�nia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "S�o Paulo"),
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
