package domain.user;

import domain.book.Book;

import java.util.List;

public final class Books {
    private List<Book> books;

    public Books(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
    public static Books of(List<Book> books){
        return new Books(books);
    }


}
