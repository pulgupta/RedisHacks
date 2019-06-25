package com.pulgupta.tryouts.redis.redisLearning.controller;

import com.pulgupta.tryouts.redis.redisLearning.model.Student;
import com.pulgupta.tryouts.redis.redisLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        Optional<Student> student = studentService.getStudent(id);
        if(student.isPresent())
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            Optional<Student> retrievedStudent = studentService.getStudent(student.getId());
            return new ResponseEntity(studentService.updateStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@RequestParam String id) {
        try {
            Optional<Student> retrievedStudent = studentService.getStudent(id);
            studentService.deleteStudent(retrievedStudent.get().getId());
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }
}
