package br.com.zupacademy.carlivan.casadocodigo.validation;

import br.com.zupacademy.carlivan.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.carlivan.casadocodigo.model.Estado;
import br.com.zupacademy.carlivan.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaEstadoPaisValidator implements ConstraintValidator<ValidaEstadoPais, EstadoForm> {
    @Autowired
    private EstadoRepository estadoRepository;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(EstadoForm estadoForm, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Estado> optional = estadoRepository.findByNomeEstadoAndPaisId(estadoForm.getNomeEstado(), estadoForm.getIdPais());

        return !optional.isPresent();
    }
}
