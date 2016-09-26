package com.su.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Андрей on 20.09.2016.
 */
public class Bid {

    private User bider;
    private Date bidDate;
    private BigDecimal bidValue;
    private BigDecimal priceAfterBid;

    public Bid(User bider, Date bidDate, BigDecimal bidValue, BigDecimal priceAfterBid) {
        this.bider = bider;
        this.bidDate = bidDate;
        this.bidValue = bidValue;
        this.priceAfterBid = priceAfterBid;
    }

    public User getBider() {
        return bider;
    }

    public void setBider(User bider) {
        this.bider = bider;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public BigDecimal getBidValue() {
        return bidValue;
    }

    public void setBidValue(BigDecimal bidValue) {
        this.bidValue = bidValue;
    }

    public BigDecimal getPriceAfterBid() {
        return priceAfterBid;
    }

    public void setPriceAfterBid(BigDecimal priceAfterBid) {
        this.priceAfterBid = priceAfterBid;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bider=" + bider +
                ", bidDate=" + bidDate +
                ", bidValue=" + bidValue +
                ", priceAfterBid=" + priceAfterBid +
                '}';
    }
}
