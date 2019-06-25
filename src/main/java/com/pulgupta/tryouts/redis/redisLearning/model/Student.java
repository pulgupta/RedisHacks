package com.pulgupta.tryouts.redis.redisLearning.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Hashes are nothing but objects in the world of redis.
 * Other than this redis notation this is a normal POJO
 * @author pulgupta
 */
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