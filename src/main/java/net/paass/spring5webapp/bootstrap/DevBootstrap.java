package net.paass.spring5webapp.bootstrap;

import net.paass.spring5webapp.model.Author;
import net.paass.spring5webapp.model.Book;
import net.paass.spring5webapp.repositories.AuthorRepository;
import net.paass.spring5webapp.repositories.BookRepsitory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepsitory bookRepsitory;

  public DevBootstrap(AuthorRepository authorRepository, BookRepsitory bookRepsitory) {
    this.authorRepository = authorRepository;
    this.bookRepsitory = bookRepsitory;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {

    // Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepsitory.save(ddd);

    // Rod
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepsitory.save(noEJB);
  }

}
