package com.su.service.dao.api;

import java.util.List;

/**
 * Created by Инна on 17.09.2016.
 */
public interface GenericDao<T> {

    List<T> getAll();
    void add(T entity);
    void remove(T entity);
}
