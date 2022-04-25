package domain.book;

public final class Book {
    private final BookId bookId;
    private Isbn isbn;
    private BookName bookName;
    private Author author;
    private Page page;
    private Year year;


    private Book(BookId bookId, Isbn isbn, BookName bookName) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.bookName = bookName;
    }
    public Book(Builder builder){
        this(builder.bookId,builder.isbn,builder.bookName);
        this.author=builder.author;
        this.page=builder.page;
        this.year=builder.year;
    }

    public Book(BookId bookId, Isbn isbn, BookName bookName, Author author, Page page, Year year) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.page = page;
        this.year = year;
    }

    public static class Builder{
        private BookId bookId;
        private Isbn isbn;
        private BookName bookName;
        private Author author;
        private Page page;
        private Year year;
        public Builder bookId(String bookId){
            this.bookId = BookId.of(bookId);
            return this;
        }
        public Builder isbn(String isbn){
            this.isbn=Isbn.of(isbn);
            return this;
        }
        public Builder bookName(String bookName){
            this.bookName=BookName.of(bookName);
            return this;
        }
        public Builder author(String author){
            this.author=Author.of(author);
            return this;
        }
        public Builder page(int page){
            this.page=Page.of(page);
            return this;
        }public Builder year(int year){
            this.year=Year.of(year);
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
    public BookId getBookId() {
        return bookId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public BookName getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId.getValue() +
                ", isbn=" + isbn.getIsbn() +
                ", bookName=" + bookName.getValue() +
                ", author=" + author.getValue() +
                ", page=" + page.getValue() +
                ", year=" + year.getValue() +
                '}';
    }
}
