package com.modelo.projeto.entity;

import java.util.EnumSet;

/**
 *
 * @author vcoelho
 */
public enum EnumSexo {

	FEMININO("F", "Feminino"),
	MASCULINO("M", "Masculino");

	EnumSexo(String codigo, String tipo) {
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

	public static EnumSet<EnumSexo> getListaTipoSexo() {
		return EnumSet.of(FEMININO, MASCULINO);
	}
}
