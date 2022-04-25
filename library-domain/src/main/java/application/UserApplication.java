package application;

import domain.book.Book;
import domain.user.Identity;
import domain.user.Officer;
import domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserApplication {
    List<User> getAllUsers();

    Optional<User> addUser(User user);

    boolean removeUser(User user);

    Optional<User> updateUser(User user);

    Optional<User> findById(Identity identity);

    Boolean existsById(Identity identity);
}
