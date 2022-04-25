package repository;

import domain.book.Book;
import domain.book.BookId;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAllBooks();

    boolean existsByIdentity(BookId bookId);

    Optional<Book> addBook(Book book);

    boolean removeBook(Book book);

    Book updateBook(Book book);

    Optional<Book> findByBookId(BookId bookId);
}
