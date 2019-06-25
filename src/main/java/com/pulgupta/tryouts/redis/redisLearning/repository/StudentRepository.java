package com.pulgupta.tryouts.redis.redisLearning.repository;

import com.pulgupta.tryouts.redis.redisLearning.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}
