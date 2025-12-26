package com.student.api.Controllers;

import com.student.api.DTOs.StudentDTO;
import com.student.api.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/Student")
public class StudentController {

    @Autowired
    StudentService studService;

    @GetMapping(path="/Get")
    public List<StudentDTO> getStudents()
    {
        return studService.getStudents();
    }

    @PostMapping(path="/Post")
    public StudentDTO postStudent( @Valid @RequestBody StudentDTO studentDTO)
    {
        return studService.postStudent(studentDTO);
    }

    @PutMapping(path="/Put/{id}")
    public StudentDTO updateFulStudent(@PathVariable Long id, @RequestBody StudentDTO stud)
    {
        return studService.updateFulStudent(id,stud);
    }

    @PatchMapping(path="/Patch/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody Map<String,Object> stud)
    {
        return studService.updateStudent(id,stud);
    }

    @DeleteMapping(path="/Delete/{id}")
    public String deleteStudentById(@PathVariable Long id)
    {
        if(studService.deleteStudentById(id))
            return "Student Deleted Successfully...";
        else
            return "Student Not Found...";
    }

    @GetMapping(path="/Get/{id}")
    public StudentDTO getStudentById(@PathVariable Long id)
    {
        return studService.getStudentById(id);
    }

}
