package com.pulgupta.tryouts.redis.redisLearning.service;

import com.pulgupta.tryouts.redis.redisLearning.model.Student;
import com.pulgupta.tryouts.redis.redisLearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudent(String id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student) {
        Optional<Student> retrievedStudent = studentRepository.findById(student.getId());
        if(!retrievedStudent.isPresent())
            throw new RuntimeException("User not found");
        return studentRepository.save(student);
    }

    public boolean deleteStudent(String id) {
        Optional<Student> retrievedStudent = studentRepository.findById(id);
        // If user is not found return false to indicate that the user is not updated
        if(!retrievedStudent.isPresent())
            throw new RuntimeException("User not found");
        studentRepository.delete(retrievedStudent.get());
        return true;
    }
}
