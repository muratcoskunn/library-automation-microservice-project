package domain.book;

public final class BookId {
    private String identity;


    public BookId(String identity) {
        this.identity = identity;
    }
    public static BookId of(String identity){
        return new BookId(identity);
    }

    public String getValue() {
        return identity;
    }
}
