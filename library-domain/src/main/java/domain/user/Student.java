package domain.user;

import domain.book.Book;

import java.util.List;

public class Student extends User{
    private final Identity identity;
    private FullName fullName;
    private Department department;
    public Student(Identity identity) {
        this.identity = identity;
        this.fullName = fullName;
    }

    private Student(Builder builder){
        this(builder.identity);
        builder.fullName=fullName;
        this.department=builder.department;
    }
    public static class Builder{
        private Identity identity;
        private FullName fullName;
        private Department department;

        public Builder identity(String identity){
            this.identity=Identity.of(identity);
            return this;
        }
        public Builder fullName(String name,String surname){
            this.fullName= FullName.of(name,surname);
            return this;
        }
        public Builder department(String department){
            this.department = Department.of(department);
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    @Override
    public FullName getFullName() {
        return fullName;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }
}
