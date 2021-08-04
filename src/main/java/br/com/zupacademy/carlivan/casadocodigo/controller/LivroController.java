package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.carlivan.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Livro;
import br.com.zupacademy.carlivan.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private LivroRepository livroRepository;


    @PostMapping
    public void criaLivro(@RequestBody @Valid LivroForm form){

        Livro livro = form.toLivro(manager);
        livroRepository.save(livro);
    }

    @GetMapping
    public Stream<LivroDto> listaLivroDto(){
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.listaLivro(livros);
    }
}
