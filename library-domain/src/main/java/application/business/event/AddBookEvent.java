package application.business.event;

public class AddBookEvent extends BookEvent {
    public AddBookEvent(String identity) {
        super(identity);
    }
}
