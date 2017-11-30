package com.ttms.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/16
 * Time: 16:03
 */
public class Sale_item implements Serializable {
    private Integer sale_item_id;
    private Integer ticket_id;
    private Integer sale_id;
    private Double sale_item_price;

    public Integer getSale_item_id() {
        return sale_item_id;
    }

    public void setSale_item_id(Integer sale_item_id) {
        this.sale_item_id = sale_item_id;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Double getSale_item_price() {
        return sale_item_price;
    }

    public void setSale_item_price(Double sale_item_price) {
        this.sale_item_price = sale_item_price;
    }
}
