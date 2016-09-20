package com.su.main;

import com.su.service.AuctionService;
import com.su.service.ItemService;
import com.su.service.UserServise;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void  main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:NoXML.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);
        UserServise userService = context.getBean(UserServise.class);
        ItemService itemService = context.getBean(ItemService.class);


        System.out.println("Users quantity " + userService.getUsers().size());

    }


}
