package org.sundrysnippets.firstWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.sundrysnippets.firstWebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
