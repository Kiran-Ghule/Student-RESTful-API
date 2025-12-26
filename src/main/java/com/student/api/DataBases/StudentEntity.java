package com.student.api.DataBases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String Name;
    private String cls;
    private Double percentage;
    private String Email;

}
