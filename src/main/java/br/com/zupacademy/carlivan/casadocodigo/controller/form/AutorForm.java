package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Autor;
import br.com.zupacademy.carlivan.casadocodigo.model.Categoria;
import br.com.zupacademy.carlivan.casadocodigo.validation.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
