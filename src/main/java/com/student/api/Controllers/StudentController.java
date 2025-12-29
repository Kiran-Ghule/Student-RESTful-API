package com.student.api.Controllers;

import com.student.api.DTOs.StudentDTO;
import com.student.api.Exceptions.NotFound;
import com.student.api.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/Student")
public class StudentController {

    @Autowired
    StudentService studService;

    @GetMapping(path="/Get")
    public ResponseEntity<List<StudentDTO>> getStudents()
    {
        return new ResponseEntity<>(studService.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping(path="/Post")
    public ResponseEntity<StudentDTO> postStudent( @Valid @RequestBody StudentDTO studentDTO)
    {
        return new ResponseEntity<>(studService.postStudent(studentDTO),HttpStatus.CREATED);
    }

    @PutMapping(path="/Put/{id}")
    public ResponseEntity<StudentDTO> updateFulStudent(@PathVariable Long id, @RequestBody StudentDTO stud)
    {
        return new ResponseEntity<>(studService.updateFulStudent(id,stud),HttpStatus.ACCEPTED);
    }

    @PatchMapping(path="/Patch/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody Map<String,Object> stud)
    {
        return new ResponseEntity<>(studService.updateStudent(id,stud), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path="/Delete/{id}")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable Long id)
    {
        if(studService.deleteStudentById(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path="/Get/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id)
    {
        StudentDTO stud=studService.getStudentById(id);
        if(stud==null)
            throw new NotFound("Student of Id "+id+" Not Found");
        else
            return new ResponseEntity<>(stud,HttpStatus.FOUND);
    }

}
