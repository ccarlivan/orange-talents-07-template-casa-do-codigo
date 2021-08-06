package br.com.zupacademy.carlivan.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeEstado;
    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(String nomeMes, Pais pais) {
        this.nomeEstado = nomeMes;
        this.pais = pais;
    }

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }
}
