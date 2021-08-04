package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Livro;
import br.com.zupacademy.carlivan.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.carlivan.casadocodigo.validation.VerificaAutorExisteValidator;
import br.com.zupacademy.carlivan.casadocodigo.validation.VerificaCategoriaExisteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private VerificaAutorExisteValidator verificaAutorExisteValidator;
    @Autowired
    private VerificaCategoriaExisteValidator verificaCategoriaExisteValidator;
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private LivroRepository livroRepository;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(verificaAutorExisteValidator, verificaCategoriaExisteValidator);
    }

    @PostMapping
    public void criaLivro(@RequestBody @Valid LivroForm form){

        Livro livro = form.toLivro(manager);
        livroRepository.save(livro);
    }
}
