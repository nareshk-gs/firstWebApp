package org.sundrysnippets.firstWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.sundrysnippets.firstWebApp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
