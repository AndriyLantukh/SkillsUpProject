package com.su.service;

import com.su.domain.Bid;
import com.su.service.dao.api.LotDao;
import com.su.service.dao.api.UserDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotDao lotDao;


    @Override
    public Lot createLot(Item item, User owner, BigDecimal startPrice) {
        if(getActiveLots().stream().anyMatch(lot -> lot.getItem().equals(item))) {
            System.out.println("Lot with item " +item.getTitle()+ " already present. You can't create this lot.");
            return null;
        }
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(owner);
        lot.setStartPrice(startPrice);
        lot.setCurrentPrice(startPrice);
        lot.setDatePlaced(new Date());
        lot.setBidHistory(new ArrayList<>());
        lotDao.add(lot);
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public void placeBid(Lot lot, User bider) {
        if (lot.getOwner().equals(bider)) {
            System.out.println("You can't bid. You are owner.");
            return;
        }
        BigDecimal bidValue = lot.getBidValue();
        makeBid(lot, bider, bidValue);
    }

    @Override
    public void placeBid(Lot lot, User bider, BigDecimal newPrice) {
        if (lot.getOwner().equals(bider)) {
            System.out.println("You can't bid. You are owner.");
            return;
        }
        if (newPrice.compareTo(lot.getCurrentPrice()) <= 0) {
            System.out.println("Your price less than current price");
            return;
        }
        BigDecimal bidValue = newPrice.subtract(lot.getCurrentPrice());
        makeBid(lot, bider, bidValue);
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setDateEnd(new Date());
        List<Bid> bidHistory = lot.getBidHistory();
        if (bidHistory.size() == 0) {
            return lot;
        }
        lot.setBuyer(bidHistory.get(bidHistory.size() - 1).getBider());
        return lot;
    }

    @Override
    public Lot getLotByItemTitle(String title){
        if(lotDao.getAll().stream().noneMatch(lot -> lot.getItem().getTitle().equals(title))) {
            return null;
        }
        return lotDao.getAll().stream().filter(lot -> lot.getItem().getTitle().equals(title)).findFirst().get();
    }

    @Override
    public Lot getActiveLotByItemTitle(String title){
        if(getActiveLots().stream().noneMatch(lot -> lot.getItem().getTitle().equals(title))) {
            return null;
        }
        return getActiveLots().stream().filter(lot -> lot.getItem().getTitle().equals(title)).findFirst().get();
    }

    private void makeBid(Lot lot, User bider, BigDecimal bidValue) {
        BigDecimal priceAfterBid = lot.getCurrentPrice().add(bidValue);
        Bid bid = new Bid(bider, new Date(), bidValue, priceAfterBid);
        lot.setCurrentPrice(priceAfterBid);
        lot.addBid(bid);
    }

}
