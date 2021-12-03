package com.student.data.studentController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.studentRepo.StudentRepository;
import com.student.data.studentRecord.*;


@RestController
public class StudentController {
	@Autowired
	StudentRepository studentrepo;
	
	@GetMapping("/students")
	private List<StudentRecord> getallStudent()
	{
		List<StudentRecord> students = new ArrayList<StudentRecord>();  
		studentrepo.findAll().forEach(students::add);  
		return students;  
	}
	@GetMapping("/students/{studentid}")  
	private StudentRecord getStudent(@PathVariable("studentid") int studentid) 
	{
		return studentrepo.findById(studentid).get();
	}
	@DeleteMapping("/students/{studentid}")
	private void deleteStudent(@PathVariable("studentid") int studentid)  
	{
		studentrepo.deleteById(studentid);
	}
	@PostMapping("/students")
	private int saveStudent(@RequestBody StudentRecord student)
	{
		studentrepo.save(student);
		return student.getStudentid();
	}
	@PutMapping("/students")
	private StudentRecord updateStudent(@RequestBody StudentRecord student)
	{
		studentrepo.save(student);
		return student;
	}

}
