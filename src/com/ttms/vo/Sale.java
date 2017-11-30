package com.ttms.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/16
 * Time: 15:52
 */
public class Sale implements Serializable {
    private Integer sale_id;
    private Integer emp_id;
    private Date sale_time;
    private Double sale_payment;
    private Double change;
    private Integer sale_type;
    private Integer sale_status;

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Date getSale_time() {
        return sale_time;
    }

    public void setSale_time(Date sale_time) {
        this.sale_time = sale_time;
    }

    public Double getSale_payment() {
        return sale_payment;
    }

    public void setSale_payment(Double sale_payment) {
        this.sale_payment = sale_payment;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Integer getSale_type() {
        return sale_type;
    }

    public void setSale_type(Integer sale_type) {
        this.sale_type = sale_type;
    }

    public Integer getSale_status() {
        return sale_status;
    }

    public void setSale_status(Integer sale_status) {
        this.sale_status = sale_status;
    }
}