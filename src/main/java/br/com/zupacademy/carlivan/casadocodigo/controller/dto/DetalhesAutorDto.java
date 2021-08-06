package br.com.zupacademy.carlivan.casadocodigo.controller.dto;

import br.com.zupacademy.carlivan.casadocodigo.model.Autor;

public class DetalhesAutorDto {
    private String nome;
    private String descricao;

    public DetalhesAutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
