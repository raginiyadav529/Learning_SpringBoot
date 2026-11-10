package com.ragini.repository;

import com.ragini.model.Profile;
import com.ragini.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Profile profile) {

        entityManager.persist(profile);
    }
}
