package repository;

import domain.user.Identity;
import domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository<T extends User> {
    List<T> getAllUsers();

    boolean existsByIdentity(Identity identity);

    Optional<T> addUser(T t);

    boolean removeUser(T t);

   T updateUser(T t);

    Optional<T> findById(Identity identity);

}
