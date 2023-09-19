package com.softserve.blog.dao.impl;

import com.softserve.blog.dao.UserDAO;
import com.softserve.blog.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        Query query = entityManager.createNativeQuery("select * from users where id = :id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
}
