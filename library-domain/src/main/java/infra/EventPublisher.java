package infra;

import application.business.event.BookEvent;
import application.business.event.UserEvent;

public interface EventPublisher {

    void publish(UserEvent userEvent);
    void publish(BookEvent bookEvent);
}
