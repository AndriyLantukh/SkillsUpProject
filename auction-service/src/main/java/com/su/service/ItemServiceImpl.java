package com.su.service;

import com.su.domain.Item;
import com.su.service.dao.api.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Андрей on 20.09.2016.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }

    @Override
    public Item createItem(String title, String description) {
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        itemDao.add(item);
        return item;
    }
}
