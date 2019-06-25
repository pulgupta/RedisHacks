package com.pulgupta.tryouts.redis.redisLearning.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }
}