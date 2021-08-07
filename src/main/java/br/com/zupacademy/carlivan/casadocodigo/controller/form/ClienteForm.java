package br.com.zupacademy.carlivan.casadocodigo.controller.form;

import br.com.zupacademy.carlivan.casadocodigo.model.Cliente;
import br.com.zupacademy.carlivan.casadocodigo.model.Estado;
import br.com.zupacademy.carlivan.casadocodigo.model.Pais;
import br.com.zupacademy.carlivan.casadocodigo.validation.ExistId;
import br.com.zupacademy.carlivan.casadocodigo.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(String nome, String sobrenome, String email, String documento,
                       String endereco, String complemento, String cidade, Long idPais,
                       Long idEstado, String telefone, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toCliente(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Estado estado;
        if(idEstado != null){
            estado = manager.find(Estado.class, idEstado);
        }else {
            estado = null;
        }

        return new Cliente(this.nome,this.sobrenome,this.email,this.documento,this.endereco,this.complemento,this.cidade,
                pais, estado, this.telefone, this.cep);
    }
}
