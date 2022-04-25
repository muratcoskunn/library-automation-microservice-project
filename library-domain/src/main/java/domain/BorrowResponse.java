package domain;

import domain.book.Book;
import domain.user.User;

public class BorrowResponse {
    private User user;
    private Book book;
    private boolean borrowResult;

    public BorrowResponse(User user, Book book,boolean borrowResult) {
        this.borrowResult=borrowResult;
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isBorrowResult() {
        return borrowResult;
    }

    public void setBorrowResult(boolean borrowResult) {
        this.borrowResult = borrowResult;
    }
}
