package domain.user;

public class FullName {
    private final String name;
    private final String surname;

    private FullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public static FullName of (String name, String surname){
        return new FullName(name,surname);
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
