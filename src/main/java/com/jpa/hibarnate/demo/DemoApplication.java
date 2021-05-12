package com.jpa.hibarnate.demo;

import com.jpa.hibarnate.demo.entity.Course;
import com.jpa.hibarnate.demo.repository.CourseRepository;
import com.jpa.hibarnate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	studentRepository.saveStudentWithPassport();


//		Course course=repository.findById(2L);
//
//		logger.info("course:-->",course);
//		repository.save(new Course("Microservise"));
	}
}
