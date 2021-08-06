package br.com.zupacademy.carlivan.casadocodigo.controller.dto;

import br.com.zupacademy.carlivan.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DetalhesLivroDto {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private String dataPublicacao;
    //private String nomeCategoria;
    private DetalhesAutorDto autor;

    public DetalhesLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = String.format(String.valueOf(livro.getDataPublicacao()),new SimpleDateFormat("dd/MM/yyyy"));
        //this.nomeCategoria = livro.getCategoria().getNome();
        this.autor = new DetalhesAutorDto(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalhesAutorDto getAutor() {
        return autor;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
