package br.com.zupacademy.carlivan.casadocodigo.repository;

import br.com.zupacademy.carlivan.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
