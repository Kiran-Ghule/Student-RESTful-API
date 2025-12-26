package com.student.api.DTOs;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @Length(min=3, max=10)
    private String Name;

    @NotEmpty
    private String cls;

    @Digits(integer = 2,fraction = 2)
    @DecimalMin(value="0.01")
    @DecimalMax(value="99.99")
    private Double percentage;

    @Email
    @NotEmpty
    private String Email;
}
