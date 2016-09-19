package com.su.service.dao.impl;

import com.su.service.dao.api.ItemDao;
import com.su.domain.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Инна on 17.09.2016.
 */
@Component
public class ItemDaoImpl implements ItemDao {

    private List<Item> items = new ArrayList<>();


    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void add(Item entity) {
        items.add(entity);
    }

    @Override
    public void remove(Item entity) {
        items.remove(entity);
    }
}