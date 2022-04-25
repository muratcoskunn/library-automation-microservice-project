package application.business.event;

public class UserEvent {
    private String identity;

    public UserEvent(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}
