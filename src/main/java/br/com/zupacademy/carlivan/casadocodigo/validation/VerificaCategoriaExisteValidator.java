package br.com.zupacademy.carlivan.casadocodigo.validation;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaCategoriaExisteValidator implements Validator {
    @Autowired
    private CategoriaRepository categoriaRepository;

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

        Optional<Categoria> optional = categoriaRepository.findById(form.getIdCategoria());

        if(optional.isEmpty()){
            errors.rejectValue("idCategoria",null,"Categoria não encontrada ou não cadastrada");
        }

    }
}
