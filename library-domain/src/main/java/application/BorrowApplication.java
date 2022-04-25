package application;

import domain.BorrowResponse;
import domain.book.Book;
import domain.user.User;

public interface BorrowApplication {
    BorrowResponse borrow(User user , Book book);
}
