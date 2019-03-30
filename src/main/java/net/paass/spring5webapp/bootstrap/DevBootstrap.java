package net.paass.spring5webapp.bootstrap;

import net.paass.spring5webapp.model.Author;
import net.paass.spring5webapp.model.Book;
import net.paass.spring5webapp.model.Publisher;
import net.paass.spring5webapp.repositories.AuthorRepository;
import net.paass.spring5webapp.repositories.BookRepsitory;
import net.paass.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepsitory bookRepsitory;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository,
      BookRepsitory bookRepsitory,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepsitory = bookRepsitory;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {

    // Eric
    Author eric = new Author("Eric", "Evans");
    Publisher harperCollins = new Publisher("Harper Collins", "Harper Collins Street" );
    Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    publisherRepository.save(harperCollins);
    bookRepsitory.save(ddd);

    // Rod
    Author rod = new Author("Rod", "Johnson");
    Publisher worx = new Publisher("Worx", "Worx Street" );
    Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    publisherRepository.save(worx);
    bookRepsitory.save(noEJB);
  }

}
