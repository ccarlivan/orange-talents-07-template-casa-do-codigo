package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Pais;
import br.com.zupacademy.carlivan.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;

    public PaisForm(String nomePais) {
        this.nomePais = nomePais;
    }

    public PaisForm() {
    }

    public Pais toPais() {
        return new Pais(this.nomePais);
    }

    public String getNomePais() {
        return nomePais;
    }
}
