package controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import controller.form.OrdenadorForm;

@Component
public class OrdenadorFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(OrdenadorForm.class);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		OrdenadorForm ordenadorForm = (OrdenadorForm) obj;
		
		if (ordenadorForm.getNombre() == null || ordenadorForm.getNombre().trim().equals(""))
			errores.reject("nombre", "Nombre inválido");
		if (ordenadorForm.getSerial() == null || ordenadorForm.getSerial().trim().equals(""))
			errores.reject("serial", "Serial inválido");
	}

}
