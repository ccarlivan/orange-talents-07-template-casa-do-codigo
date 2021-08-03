package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public void salvar(@RequestBody @Valid AutorForm form){
        Autor autor = form.toAutor();
        autorRepository.save(autor);
    }
}
