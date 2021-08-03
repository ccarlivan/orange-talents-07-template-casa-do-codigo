package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.carlivan.casadocodigo.validation.VerificaCategoriaDuplicadaValidator;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaRepository categoriaRepository;
    private VerificaCategoriaDuplicadaValidator verificaCategoriaDuplicadaValidator;

    public CategoriaController(CategoriaRepository categoriaRepository,
                               VerificaCategoriaDuplicadaValidator verificaCategoriaDuplicadaValidator) {
        this.categoriaRepository = categoriaRepository;
        this.verificaCategoriaDuplicadaValidator = verificaCategoriaDuplicadaValidator;
    }
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(verificaCategoriaDuplicadaValidator);
    }

    @PostMapping
    @Transactional
    public void salvaCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.toCategoria();
        categoriaRepository.save(categoria);
    }
}
