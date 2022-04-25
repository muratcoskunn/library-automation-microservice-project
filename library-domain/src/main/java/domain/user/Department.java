package domain.user;

import java.util.Objects;

public class Department {
    private final String department;

    private Department(String department) {
        this.department = department;
    }
    public static Department of(String department){
        Objects.requireNonNull(department);
        return new Department(department);
    }

    public String getValue() {
        return department;
    }
}
