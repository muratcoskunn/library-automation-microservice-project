package com.sahabt.officermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "officers")
public class OfficerEntity {
    @Id
    private String officerId;
    private String name;
    private String surname;
    private String department;
    @OneToOne
    private BookEntity bookEntity;

    public OfficerEntity(String officerId, String name, String surname, String department) {
        this.officerId = officerId;
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficerEntity that = (OfficerEntity) o;
        return Objects.equals(officerId, that.officerId) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officerId);
    }
}
