package application;

import domain.book.Book;
import domain.book.BookId;
import domain.user.Identity;

import java.util.List;
import java.util.Optional;

public interface BookApplication {
    List<Book> getAllBooks();

    Optional<Book> addBook(Book book);

    boolean removeBook(Book book);

    Optional<Book> updateBook(Book book);

    Optional<Book> findByBookId(BookId bookId);

    Boolean existsById(BookId bookId);
}
