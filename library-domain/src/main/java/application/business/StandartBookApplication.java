package application.business;

import application.BookApplication;
import application.business.event.AddBookEvent;
import domain.book.Book;
import domain.book.BookId;
import domain.user.Identity;
import infra.EventPublisher;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class StandartBookApplication implements BookApplication {
    BookRepository bookRepository;
    EventPublisher eventPublisher;

    public StandartBookApplication(BookRepository bookRepository, EventPublisher eventPublisher) {
        this.bookRepository = bookRepository;
        this.eventPublisher = eventPublisher;
    }
    @Override
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    @Override
    public Optional<Book> addBook(Book book){
        var identity = book.getBookId();
        if(bookRepository.existsByIdentity(identity))
            return Optional.empty();
        bookRepository.addBook(book);
        eventPublisher.publish(new AddBookEvent(identity.getValue()));
        return Optional.of(book);
    }
    @Override
    public boolean removeBook(Book book){
        var identity = book.getBookId();
        if(bookRepository.existsByIdentity(identity)) {
            bookRepository.removeBook(book);
            return true;
        }
        return false;
    }
    @Override
    public Optional<Book> updateBook(Book book){
        var identity = book.getBookId();
        if (bookRepository.existsByIdentity(identity)){
            var updatedBook =bookRepository.updateBook(book);
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByBookId(BookId bookId) {
        return bookRepository.findByBookId(bookId);
    }

    @Override
    public Boolean existsById(BookId bookId) {
        return bookRepository.existsByIdentity(bookId);
    }
}
