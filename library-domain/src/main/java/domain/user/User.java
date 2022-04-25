package domain.user;


public abstract class User {
    private Identity identity;
    private FullName fullName;
    private Department department;
    private Books books;

    public User() {
    }

    public Identity getIdentity() {
        return identity;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
