package application.business;

import application.BorrowApplication;
import domain.BorrowResponse;
import domain.book.Book;
import domain.user.User;

public class StandartBorrowApplication implements BorrowApplication {
    @Override
    public BorrowResponse borrow(User user, Book book) {
        return null;
    }
}
