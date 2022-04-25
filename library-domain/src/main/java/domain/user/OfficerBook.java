package domain.user;

import java.util.Objects;

public class OfficerBook {
    private String bookId;

    public OfficerBook(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficerBook that = (OfficerBook) o;
        return Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return "OfficerBook{" +
                "bookId='" + bookId + '\'' +
                '}';
    }
}
