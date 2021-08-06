package br.com.zupacademy.carlivan.casadocodigo.repository;

import br.com.zupacademy.carlivan.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNomeEstado(String nomeEstado);

    Optional<Estado> findByNomeEstadoAndPaisId(String nomeEstado, Long idPais);
}
