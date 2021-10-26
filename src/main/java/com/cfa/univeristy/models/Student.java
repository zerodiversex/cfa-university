package com.cfa.univeristy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    @ManyToOne
    //@JoinColumn(name="department_id", nullable=false)
    private Department department;

    @Transient
    public String getFullName() {
        return firstName + "." + lastName;
    }
}
