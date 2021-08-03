package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nomeCategoria;

    public CategoriaForm(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaForm() {
    }

    public Categoria toCategoria(){
        return new Categoria(this.nomeCategoria);
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
