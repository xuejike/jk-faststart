package com.github.xuejike.springboot.jkfaststart.service;

import com.bidanet.bdcms.core.vo.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gange on 2017/7/12.
 */
public interface BaseService<T,K extends Serializable> {

    T get(K id);

    List<T> getList();
    void save(T entity);
    void update(K id,Object obj);
    void delete(K id);

    void eqPage(T t, Page<T> page);

}
