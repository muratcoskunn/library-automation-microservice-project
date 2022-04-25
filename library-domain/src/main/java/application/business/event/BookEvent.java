package application.business.event;

public class BookEvent {
    private final String identity;

    public BookEvent(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}
