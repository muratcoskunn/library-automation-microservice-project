package application.business;

import application.business.event.AddUserEvent;
import application.UserApplication;
import domain.book.Book;
import domain.user.Identity;
import domain.user.Officer;
import domain.user.User;
import infra.EventPublisher;
import repository.UserCrudRepository;

import java.util.List;
import java.util.Optional;

public class StandartUserApplication implements UserApplication {
    UserCrudRepository userRepository;
    EventPublisher eventPublisher;

    public StandartUserApplication(UserCrudRepository userRepository, EventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher= eventPublisher;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> addUser(User user) {
        var identity = user.getIdentity();
        if(userRepository.existsByIdentity(identity))
            return Optional.empty();
        userRepository.addUser(user);
        eventPublisher.publish(new AddUserEvent(identity.getValue()));
        return Optional.of(user);
    }

    @Override
    public boolean removeUser(User user) {
        var identity = user.getIdentity();
        if(userRepository.existsByIdentity(identity)) {
            userRepository.removeUser(user);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> updateUser(User user) {
        var identity = user.getIdentity();
        if (userRepository.existsByIdentity(identity)){
            var updatedUser = userRepository.updateUser(user);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Identity identity) {
        return userRepository.findById(identity);
    }

    @Override
    public Boolean existsById(Identity identity) {
        return userRepository.existsByIdentity(identity);
    }


}
