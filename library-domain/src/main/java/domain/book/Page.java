package domain.book;

public final class Page {
    private final int page;

    private Page(int page) {
        this.page = page;
    }
    public static Page of(int page){
        return new Page(page);
    }

    public int getValue() {
        return page;
    }
}
