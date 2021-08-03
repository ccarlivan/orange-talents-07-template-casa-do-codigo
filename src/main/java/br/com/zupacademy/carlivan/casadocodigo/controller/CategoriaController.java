package br.com.zupacademy.carlivan.casadocodigo.controller;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.repository.CategoriaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public void salvaCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.toCategoria();
        categoriaRepository.save(categoria);
    }
}
