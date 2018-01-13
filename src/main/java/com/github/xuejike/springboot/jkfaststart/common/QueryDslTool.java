package com.github.xuejike.springboot.jkfaststart.common;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class QueryDslTool {
    @Autowired
    EntityManager entityManager;
    public JPAQuery getQuery(){
        JPAQuery<Object> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery;
    }
}
