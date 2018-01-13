package com.github.xuejike.springboot.jkfaststart.service.impl;


import com.bidanet.bdcms.core.exception.CheckException;
import com.bidanet.bdcms.core.vo.Page;

import com.github.xuejike.springboot.jkfaststart.common.LambdaQuery;
import com.github.xuejike.springboot.jkfaststart.service.BaseService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by gange on 2017/7/12.
 */
public abstract class BaseServiceImpl<T,K extends Serializable> implements BaseService<T,K> {

    @Autowired
    protected LambdaQuery lambdaQuery;
    @Autowired(required = false)
    JpaRepository<T , K> jpaRepository;
    @Autowired
    EntityManager entityManager;

    protected String orderId="id";


    @Override
    public T get(K id) {

        return jpaRepository.findOne(id);
    }

    @Override
    public List<T> getList() {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void save(T entity) {
        jpaRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(K id,Object obj){
        T one = jpaRepository.getOne(id);
        BeanUtils.copyProperties(obj,one);
        jpaRepository.save(one);
    }

    @Override
    public void delete(K id) {
        jpaRepository.delete(id);
    }

    @Override
    public void eqPage(T t, Page<T> page) {

        Session session = (Session) entityManager.getDelegate();
        Criteria id = session.createCriteria(t.getClass())
                .add(Example.create(t).enableLike(MatchMode.ANYWHERE));
        id.setFirstResult((page.getPageCurrent()-1)*page.getPageSize()).setMaxResults(page.getPageSize()).addOrder(Order.desc("id"));

        page.setList(id.list());
         Criteria countC = session.createCriteria(t.getClass()).add(Example.create(t).enableLike(MatchMode.ANYWHERE).excludeProperty("id"));
        Long result = (Long) countC.setProjection(Projections.count("id")).uniqueResult();
        page.setTotal(result);
    }

    public void errorException(String msg){
        throw new CheckException(msg);
    }


    public void checkStringEmpty(String s , String errMsg){
        if (s == null || "".equals(s)){
            errorException(errMsg);
        }
    }

    public void checkObjNull(Object o , String errMsg){
        if (o == null){
            errorException(errMsg);
        }
    }

    public void checkMoenyZero(BigDecimal bigDecimal , String errMsg){
        if (bigDecimal == null || BigDecimal.valueOf(0).equals(bigDecimal)){
            errorException(errMsg);
        }
    }

    protected void errorMsg(String msg) {
        throw new CheckException(msg);
    }
    protected void checkNull(Object obj, String msg) {
        if(obj == null) {
            throw new CheckException(msg);
        }
    }

    protected void checkString(String str, String msg) {
        this.checkNull(str, msg);
        if(str.trim().isEmpty()) {
            throw new CheckException(msg);
        }
    }


}
