package br.com.zupacademy.carlivan.casadocodigo.validation;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaEmailDuplicadoValidator implements Validator {

    private AutorRepository autorRepository;

    public VerificaEmailDuplicadoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorForm form = (AutorForm) target;
        Optional<Autor> optional = autorRepository.findByEmail(form.getEmail());
        if(optional.isPresent()){
            errors.rejectValue("email", null, "Este email já existe");
        }
    }
}
