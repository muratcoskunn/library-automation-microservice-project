package domain.book;

public final class Isbn {
    private final String Isbn;

    private Isbn(String isbn) {
        Isbn = isbn;
    }
    public static Isbn of(String isbn){
        return new Isbn(isbn);
    }

    public String getIsbn() {
        return Isbn;
    }
}
