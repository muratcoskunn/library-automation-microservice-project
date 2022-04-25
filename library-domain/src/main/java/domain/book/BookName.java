package domain.book;

public final class BookName {
    private final String bookName;

    private BookName(String bookName) {
        this.bookName = bookName;
    }
    public static BookName of(String bookName){
        return new BookName(bookName);
    }

    public String getValue() {
        return bookName;
    }
}
