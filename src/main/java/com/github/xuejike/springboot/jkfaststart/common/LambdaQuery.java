package com.github.xuejike.springboot.jkfaststart.common;

import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


/**
 * Created by xuejike on 2017/6/23.
 */
@Service
public class LambdaQuery {

    @Autowired
    EntityManager entityManager;


    public <T> LambdaCriteria<T> create(Class<T> entity){
        Session session = (Session) entityManager.getDelegate();
        LambdaCriteria<T> criteria = new LambdaCriteria<>(entity, session);
        return criteria;
    }
}
