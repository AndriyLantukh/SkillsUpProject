package com.su.main;

import com.su.service.AuctionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Инна on 17.09.2016.
 */
public class Main {

    public static void  main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:NoXML.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);


        System.out.println("Users quantity " + auctionService.getUsers().size());

    }


}
