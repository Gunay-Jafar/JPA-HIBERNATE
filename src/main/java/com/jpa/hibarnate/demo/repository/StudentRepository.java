package com.jpa.hibarnate.demo.repository;

import com.jpa.hibarnate.demo.entity.Passport;
import com.jpa.hibarnate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);

    }

    public void saveStudentWithPassport() {
        Passport passport= new Passport("Z1234567");
        em.persist(passport);

        Student student = new Student("Mike");

        student.setPassport(passport);
        em.persist(student);
    }
}
