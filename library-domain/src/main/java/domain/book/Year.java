package domain.book;

public final class Year {
    private final int year;

    private Year(int year) {
        this.year = year;
    }
    public static Year of(int year){
        return new Year(year);
    }

    public int getValue() {
        return year;
    }
}
