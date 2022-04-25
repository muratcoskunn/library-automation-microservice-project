package domain.user;


public final class Lecturer extends User{
    private final Identity identity;
    private final FullName fullName;
    private Department department;

    private Lecturer(Identity identity, FullName fullName) {
        this.identity = identity;
        this.fullName = fullName;
    }
    private Lecturer(Builder builder){
        this(builder.identity,builder.fullName);
        this.department=builder.department;
    }
    public static class Builder{
        private Identity identity;
        private Department department;
        private FullName fullName;
        public Builder identity(String identity){
            this.identity=Identity.of(identity);
            return this;
        }
        public Builder department(String department){
            this.department=Department.of(department);
            return this;
        }
        public Builder fullname(String name,String surname){
            this.fullName=FullName.of(name,surname);
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
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
