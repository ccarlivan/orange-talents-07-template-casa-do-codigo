package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Estado;
import br.com.zupacademy.carlivan.casadocodigo.model.Pais;
import br.com.zupacademy.carlivan.casadocodigo.validation.ExistId;
import br.com.zupacademy.carlivan.casadocodigo.validation.ValidaEstadoPais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ValidaEstadoPais
public class EstadoForm {
    @NotBlank
    private String nomeEstado;
    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public EstadoForm(String nomeMes, Long idPais) {
        this.nomeEstado = nomeMes;
        this.idPais = idPais;
    }

    public Estado toEstado(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(this.nomeEstado, pais);
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Long getIdPais() {
        return idPais;
    }
}
