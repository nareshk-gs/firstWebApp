package org.sundrysnippets.firstWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.sundrysnippets.firstWebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
