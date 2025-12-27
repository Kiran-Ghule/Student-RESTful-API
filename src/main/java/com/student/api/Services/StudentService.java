package com.student.api.Services;

import com.student.api.DTOs.StudentDTO;
import com.student.api.DataBases.StudentEntity;
import com.student.api.Repository.StudentRepos;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {


    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    StudentRepos sRepo;

    public List<StudentDTO> getStudents(){
            List<StudentEntity> list = sRepo.findAll();
            return list.stream()
                    .map(student->modelMapper.map(student,StudentDTO.class))
                    .collect(Collectors.toList());
    }

    public StudentDTO postStudent( StudentDTO studentDTO) {
        StudentEntity stud = modelMapper.map(studentDTO,StudentEntity.class);
        stud=sRepo.save(stud);
        return modelMapper.map(stud,StudentDTO.class);
    }

    public boolean isPresent(Long id)
    {
        return sRepo.existsById(id);
    }

    public StudentDTO updateFulStudent(Long id, StudentDTO stud) {
        StudentEntity student = modelMapper.map(stud,StudentEntity.class);
        student.setId(id);
        sRepo.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }


    public StudentDTO updateStudent(Long id, Map<String,Object> stud) {

        if(isPresent(id))
        {
            StudentEntity student = sRepo.findById(id).get();

            stud.forEach((field,value)->{
                    Field f = ReflectionUtils.findField(StudentEntity.class,field);
                    f.setAccessible(true);
                    ReflectionUtils.setField(f,student,value);
            });

            return modelMapper.map(student,StudentDTO.class);

        }
        else
            return null;
    }

    public boolean deleteStudentById(Long id) {
        if(isPresent(id))
            sRepo.deleteById(id);
        else
            return false;

        return true;
    }

    public StudentDTO getStudentById(Long id)
    {

        if(isPresent(id))
            return modelMapper.map(sRepo.findById(id).get(),StudentDTO.class);
        else
            return null;

    }
}
