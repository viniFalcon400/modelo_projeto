package com.modelo.projeto.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author vcoelho
 */
public class CpfConverter implements Converter {

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
		String cpf = value;
		if (value != null && !value.equals("")) {
			cpf = value.replaceAll("\\.", "").replaceAll("\\-", "");
		}
		return cpf;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		String cpf = (String) value;
		if (cpf != null && cpf.length() == 11) {
			cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		}
		return cpf;
	}
}
