package com.su.service;

import com.su.domain.Item;

import java.util.List;

/**
 * Created by Андрей on 20.09.2016.
 */
public interface ItemService {

    List<Item> getAll();

    Item createItem(String title, String description);

}
