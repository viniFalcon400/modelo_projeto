package com.modelo.projeto.validador;

import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author vcoelho
 */
public class EmailValidator implements Validator {

	public static final Pattern PATTERN_EMAIL = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*\\@[\\w-]+(\\.[\\w-]+)+$");

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
		if (o != null && !(o instanceof CharSequence && PATTERN_EMAIL.matcher((CharSequence) o).matches())) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ResourceBundle.getBundle("/Messages").getString("msg_email_invalido"));

			throw new ValidatorException(message);
		}

	}

}
