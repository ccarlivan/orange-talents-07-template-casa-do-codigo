package br.com.zupacademy.carlivan.casadocodigo.repository;

import br.com.zupacademy.carlivan.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
