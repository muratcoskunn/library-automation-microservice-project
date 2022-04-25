package domain.user;

import java.util.Objects;

public final class Identity {
    private final String identity;

    private Identity(String identity) {
        this.identity = identity;
    }
    public static Identity of(String identity){
        Objects.requireNonNull(identity);
        return new Identity(identity);
    }

    public String getValue() {
        return identity;
    }
}
