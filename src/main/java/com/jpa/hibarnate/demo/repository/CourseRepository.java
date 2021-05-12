package com.jpa.hibarnate.demo.repository;

import com.jpa.hibarnate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void  playWithEntityManager() {  
        Course course1=new Course("Web services in 100 steps");
        em.persist(course1);
        em.flush();

        course1.setName("Web services -Updated");
        em.flush();

        Course course2=new Course("Angular services in 100 steps");
        em.persist(course2);
        em.flush();

        em.detach(course2);

        course2.setName("Angular services -Updated");
        em.flush();
    }
}
