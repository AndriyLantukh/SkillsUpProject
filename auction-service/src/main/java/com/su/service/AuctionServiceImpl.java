package com.su.service;

import com.su.service.dao.api.LotDao;
import com.su.service.dao.api.UserDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Инна on 17.09.2016.
 */
@Service
public class AuctionServiceImpl implements  AuctionService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LotDao lotDao;



    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(user);
        lot.setStartPrice(startPrice);
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }
}
