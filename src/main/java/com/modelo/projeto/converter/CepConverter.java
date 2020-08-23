package com.modelo.projeto.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author vcoelho
 */
public class CepConverter implements Converter {

	/**
	 *
	 * @param context
	 * @param component
	 * @param value
	 * @return
	 * @throws ConverterException
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		String cep = value;
		if (value != null && !value.equals("")) {
			cep = value.replaceAll("\\.", "").replaceAll("\\-", "");
		}
		return cep;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		String cep = (String) value;
		if (cep == null) {
			return cep;
		}
		if (cep.length() < 8) {
			cep = cep + "00000000".substring(0, 8 - cep.length());
		}
		return new StringBuilder(cep.length() + 1).append(cep, 0, 5).append("-").append(cep, 5, cep.length()).toString();
	}
}
