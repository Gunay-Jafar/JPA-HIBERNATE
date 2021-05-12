package com.jpa.hibarnate.demo.repository;

import com.jpa.hibarnate.demo.DemoApplication;
import com.jpa.hibarnate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findBy() {

        Course course = courseRepository.findById(2l);

        assertEquals("JPA",course.getName());

        logger.info("Testing is Running");
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        courseRepository.deleteById(1L);

        assertNull(courseRepository.findById(1l));


    }

}
