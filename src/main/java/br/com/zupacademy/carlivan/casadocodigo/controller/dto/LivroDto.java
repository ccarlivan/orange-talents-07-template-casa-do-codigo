package br.com.zupacademy.carlivan.casadocodigo.controller.dto;

import br.com.zupacademy.carlivan.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Stream;

public class LivroDto {
    private Long id;
    private String titulo;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static Stream<LivroDto> listaLivro(List<Livro> livros){
        return livros.stream().map(LivroDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
