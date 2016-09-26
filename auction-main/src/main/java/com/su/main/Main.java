package com.su.main;

import com.su.service.AuctionService;
import com.su.service.ItemService;
import com.su.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Main {

    public static void  main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:NoXML.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);
        UserService userService = context.getBean(UserService.class);
        ItemService itemService = context.getBean(ItemService.class);

        userService.createUser("bill", "Bill", "Black");
        userService.createUser("djo", "Djo", "White");
        userService.createUser("ted", "Ted", "Gray");
        userService.createUser("dan", "Dan", "Brown");

        itemService.createItem("Item One", "Perfect");
        itemService.createItem("Item Two", "New");
        itemService.createItem("Item Three", "Used");

        auctionService.createLot(itemService.getItemByTitle("Item Two"), userService.getUserByLogin("bill"), new BigDecimal(10));

        auctionService.placeBid(auctionService.getActiveLotByItemTitle("Item Two"), userService.getUserByLogin("djo"));
        auctionService.placeBid(auctionService.getActiveLotByItemTitle("Item Two"), userService.getUserByLogin("ted"), new BigDecimal(100));
        auctionService.placeBid(auctionService.getActiveLotByItemTitle("Item Two"), userService.getUserByLogin("dan"));
        auctionService.placeBid(auctionService.getActiveLotByItemTitle("Item Two"), userService.getUserByLogin("ted"), new BigDecimal(1000));

        auctionService.closeLot(auctionService.getActiveLotByItemTitle("Item Two"));

        System.out.println(auctionService.getActiveLots().size());

        System.out.println(auctionService.getLotByItemTitle("Item Two").getBuyer());
        System.out.println(auctionService.getLotByItemTitle("Item Two").getCurrentPrice());
        auctionService.getLotByItemTitle("Item Two").getBidHistory().stream().forEach(bid -> System.out.println(bid.toString()));


    }


}
