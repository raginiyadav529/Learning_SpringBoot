package com.ragini.repo;

import com.ragini.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager ;
                                                   // create
    public void save(Student student){

        entityManager.persist(student);
    }
                                                   // read
    public Student findById(int id){

      Student s1 = entityManager.find(Student.class ,id);
      entityManager.contains(s1);
        return s1 ;
    }
                                             // delete
    public void remove(Student student){

        entityManager.remove(student);

    }

    public void saveAll(List<Student> students) {

        int counter = 0;

        for(Student student : students) {

            entityManager.persist(student);
            counter++;

            if(counter % 100 == 0) {
                entityManager.flush();                 // flush ()
                entityManager.clear();                 // clear ()
                // entityManager.refresh(student);    // refresh()
            }
        }
    }
}

