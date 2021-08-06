package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.model.Livro;
import br.com.zupacademy.carlivan.casadocodigo.validation.ExistId;
import br.com.zupacademy.carlivan.casadocodigo.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "20")
    private BigDecimal preco;
    @Min(value = 100)
    private int paginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @NotNull
    private Date dataPublicacao;
    @ExistId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @ExistId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, int paginas, String isbn,
                     String dataPublicacao, Long idCategoria, Long idAutor) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataPublicacao);

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = data;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toLivro(EntityManager manager){
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(this.titulo,this.resumo,this.sumario,this.preco,this.paginas,
                this.isbn, this.dataPublicacao,categoria,autor);
    }


    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
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

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

}
