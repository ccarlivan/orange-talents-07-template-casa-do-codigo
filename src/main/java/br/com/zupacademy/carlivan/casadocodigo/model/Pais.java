package br.com.zupacademy.carlivan.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomePais;

    public Pais(String nomePais) {
        this.nomePais = nomePais;
    }

    public Pais() {
    }

    public String getNomePais() {
        return nomePais;
    }

    public Long getId() {
        return id;
    }
}
