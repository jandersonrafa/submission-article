package br.edu.ulbra.submissoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ulbra.submissoes.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
