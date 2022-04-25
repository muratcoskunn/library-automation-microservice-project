package domain.user;

import domain.book.*;


public final class Officer extends User {
    private final Identity identity;
    private final FullName fullName;
    private Department department;
    private OfficerBook officerBook;


    private Officer(Identity identity, FullName fullName) {
        this.identity=identity;
        this.fullName=fullName;
    }
    private Officer(Builder builder){
        this(builder.identity,builder.fullName);
        this.department=builder.department;
        this.officerBook = builder.officerBook;
    }
    public static class Builder{
        private Identity identity;
        private Department department;
        private FullName fullName;
        private OfficerBook officerBook;
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
        public Builder OfficerBook(String identity){
            this.officerBook=new OfficerBook(identity);
            return this;

        }
        public Officer build(){
            return new Officer(this);
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

    public OfficerBook getOfficerBook() {
        return officerBook;
    }

    public void setOfficerBook(OfficerBook officerBook) {
        this.officerBook = officerBook;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "identity=" + identity.getValue() +
                ", fullName=" + fullName.getName()+" "+fullName.getSurname() +
                ", department=" + department.getValue() +
                ", officerBook=" + officerBook.toString() +
                '}';
    }
}
