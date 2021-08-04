package br.com.zupacademy.carlivan.casadocodigo.validation;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.carlivan.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaAutorExisteValidator implements Validator {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return LivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        LivroForm form = (LivroForm) target;

        Optional<Autor> optional = autorRepository.findById(form.getIdAutor());

        if(optional.isEmpty()){
            errors.rejectValue("idAutor",null,"Autor não encontrado ou não cadastrado");
        }

    }
}
