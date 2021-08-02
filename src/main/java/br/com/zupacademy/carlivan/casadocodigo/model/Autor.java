package br.com.zupacademy.carlivan.casadocodigo.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank @Length(max = 400)
    @Column(nullable = false)
    private String descricao;
    private LocalDateTime instante;

    public Autor(String nome, String email, String descricao) {
        Assert.hasLength(nome, "O nome é obrigatório");
        Assert.hasLength(email, "O e-mail é obrigatório");
        Assert.hasLength(descricao, "A descrição é obrigatória");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = LocalDateTime.now();
    }

    public Autor() {
    }
}
