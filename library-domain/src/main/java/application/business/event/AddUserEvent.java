package application.business.event;

public class AddUserEvent extends UserEvent {
    public AddUserEvent(String identity) {
        super(identity);
    }
}
