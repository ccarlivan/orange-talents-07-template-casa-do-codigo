package br.com.zupacademy.carlivan.casadocodigo.validation;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaCategoriaDuplicadaValidator implements Validator {
    private CategoriaRepository categoriaRepository;

    public VerificaCategoriaDuplicadaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        CategoriaForm form = (CategoriaForm) target;

        Optional<Categoria> optional = categoriaRepository.findByNome(form.getNomeCategoria());
        if(optional.isPresent()){
            errors.rejectValue("nomeCategoria",null,"Categoria já existe");
        }

    }
}
