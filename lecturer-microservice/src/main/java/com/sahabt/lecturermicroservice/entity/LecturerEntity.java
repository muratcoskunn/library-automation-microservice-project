package com.sahabt.lecturermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "lecturers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerEntity {
    @Id
    private String lecturerId;
    private String name;
    private String surname;
    private String department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturerEntity that = (LecturerEntity) o;
        return Objects.equals(lecturerId, that.lecturerId) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerId);
    }
}
