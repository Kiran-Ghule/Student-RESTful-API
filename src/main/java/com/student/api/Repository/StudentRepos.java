package com.student.api.Repository;

import com.student.api.DataBases.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface StudentRepos extends JpaRepository<StudentEntity,Long> {
}
