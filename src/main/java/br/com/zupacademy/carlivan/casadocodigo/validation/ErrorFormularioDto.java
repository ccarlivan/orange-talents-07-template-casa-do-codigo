package br.com.zupacademy.carlivan.casadocodigo.validation;

public class ErrorFormularioDto {

    private String campo;
    private String erro;

    public ErrorFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
