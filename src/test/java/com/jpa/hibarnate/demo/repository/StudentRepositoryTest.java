package com.jpa.hibarnate.demo.repository;

import com.jpa.hibarnate.demo.DemoApplication;
import com.jpa.hibarnate.demo.entity.Course;
import com.jpa.hibarnate.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void retrieveStudentAndPassport() {
        Student student = entityManager.find(Student.class, 1L);
        logger.info("student -> {}", student);
        logger.info("passport->{}", student.getPassport());
    }


}
