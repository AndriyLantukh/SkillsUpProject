package com.su.service;

import com.su.domain.Item;
import com.su.dao.api.ItemDao;
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
        if(getAll().stream().anyMatch(item -> item.getTitle().equals(title))) {
            System.out.println("Item with title " +title+ " already present. Please change title and try again.");
            return null;
        }
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        itemDao.add(item);
        return item;
    }

    @Override
    public Item getItemByTitle(String title) {
        if(itemDao.getAll().stream().noneMatch(item -> item.getTitle().equals(title))) {
            return null;
        }
        return getAll().stream().filter(item -> item.getTitle().equals(title)).findFirst().get();
    }
}
