package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.carlivan.casadocodigo.validation.VerificaEmailDuplicadoValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private AutorRepository autorRepository;
    private VerificaEmailDuplicadoValidator verificaEmailDuplicadoValidator;

    public AutorController(AutorRepository autorRepository, VerificaEmailDuplicadoValidator verificaEmailDuplicadoValidator) {
        this.autorRepository = autorRepository;
        this.verificaEmailDuplicadoValidator = verificaEmailDuplicadoValidator;
    }
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(verificaEmailDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public void salvar(@RequestBody @Valid AutorForm form){
        Autor autor = form.toAutor();
        autorRepository.save(autor);
    }
}
