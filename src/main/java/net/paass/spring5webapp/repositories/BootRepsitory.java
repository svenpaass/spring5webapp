package net.paass.spring5webapp.repositories;

import net.paass.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BootRepsitory extends CrudRepository<Book, Long> {

}
