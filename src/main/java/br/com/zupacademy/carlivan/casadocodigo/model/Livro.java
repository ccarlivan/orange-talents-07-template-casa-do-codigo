package br.com.zupacademy.carlivan.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "20")
    private double preco;
    @Min(value = 100)
    private int paginas;
    @NotBlank
    private String isbn;
    private Date dataPublicacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, double preco,
                 int paginas, String isbn, Date dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro() {    }
}
