package com.modelo.projeto.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author vcoelho
 */
public class DateConverter implements Converter {

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
		try {
			if (value != null && !value.isEmpty()) {
				return new SimpleDateFormat("yyyy-MM-dd").parse(value);
			}
		} catch (ParseException ex) {
			Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		if (o != null) {
			return new SimpleDateFormat("dd/MM/yyyy").format(o);
		}
		return null;
	}

}
