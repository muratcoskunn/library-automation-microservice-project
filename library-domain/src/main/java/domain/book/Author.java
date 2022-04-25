package domain.book;

public final class Author {
    private final String author;

    private Author(String author) {
        this.author = author;
    }
    public static Author of(String author){
        return new Author(author);
    }

    public String getValue() {
        return author;
    }
}
