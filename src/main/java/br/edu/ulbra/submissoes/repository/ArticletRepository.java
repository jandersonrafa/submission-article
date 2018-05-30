package br.edu.ulbra.submissoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ulbra.submissoes.model.Article;

@Repository
public interface ArticletRepository extends CrudRepository<Article, Long> {
}
