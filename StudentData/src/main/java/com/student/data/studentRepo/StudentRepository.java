package com.student.data.studentRepo;

import org.springframework.data.repository.CrudRepository;

import com.student.data.studentRecord.StudentRecord;

public interface StudentRepository extends CrudRepository<StudentRecord, Integer>{

}
