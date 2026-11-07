package com.ragini.repository;

import com.ragini.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
     private EntityManager entityManager;


    public void save(Department department) {

        entityManager.persist(department);
    }

    public Department getDepartmentById(Integer deptId) {

      return entityManager.find(Department.class , deptId);
    }
}
